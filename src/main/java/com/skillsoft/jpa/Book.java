package com.skillsoft.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_details")
public class Book {

    private Integer id;
    private String title;
    private String author;
    private Float price;

    public Book() {

    }

    public Book(int id, String title, String author, float price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
