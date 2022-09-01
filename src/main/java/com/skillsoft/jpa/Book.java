package com.skillsoft.jpa;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(value = BookKey.class)
public class Book {

    @Id
    private Integer titleHash;
    @Id
    private Float price;
    private String author;
    private String title;

    public Book() {

    }

    public Book(String title, String author, Float price) {
        this.title = title;
        this.author = author;
        this.titleHash = Objects.hash(title);
        this.price = price;
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
