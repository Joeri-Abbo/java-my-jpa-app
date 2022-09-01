package com.skillsoft.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "author_name", columnDefinition = "VARCHAR(55)")
    private String author;

    @Column(name = "book_title")
    private String title;

    @Column(precision = 7, scale = 4)
    private Float price;

    public Book() {

    }

    public Book(String title, String author, Float price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setPrice(Float price) {
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
