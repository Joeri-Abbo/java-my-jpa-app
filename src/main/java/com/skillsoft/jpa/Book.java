package com.skillsoft.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
public class Book {

    @Id
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
