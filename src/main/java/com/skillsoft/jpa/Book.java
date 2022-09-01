package com.skillsoft.jpa;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;

@Entity
public class Book {

    @EmbeddedId
    private BookKey bookKey;
    private String author;
    private String title;

    public Book() {

    }

    public Book(String title, String author, Float price) {
        this.title = title;
        this.author = author;
        this.bookKey = new BookKey(title, price);
    }

    public BookKey getBookKey() {
        return bookKey;
    }

    public void setBookKey(BookKey bookKey) {
        this.bookKey = bookKey;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
