package com.skillsoft.jpa;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity(name = "Categories")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Set<Product> products;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        products.add(product);
    }

    @Override
    public String toString() {
        return "\n{" + id + ", " + name + ", " + products + "}\n";
    }
}
