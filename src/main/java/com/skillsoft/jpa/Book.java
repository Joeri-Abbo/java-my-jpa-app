package com.skillsoft.jpa;

public class Book {

    private Integer id;
    private String author;

    private String title;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice(){
        return price;
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

    @Override
    public String toString() {
        return "\n{" + id + ", " + title + ", " + author + ", " + price + "}\n";
    }

}
