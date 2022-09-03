package com.skillsoft.jpa;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "Products")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {

    }

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n{" + id + ", " + name + ", " + price + "}\n";
    }
}
