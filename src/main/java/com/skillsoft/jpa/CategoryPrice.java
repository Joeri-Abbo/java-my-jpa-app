package com.skillsoft.jpa;

public class CategoryPrice {

    private String name;
    private Double avgPrice;

    public CategoryPrice() {

    }

    public CategoryPrice(String name, Double avgPrice) {
        this.name = name;
        this.avgPrice = avgPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String toString() {
        return "Category name: " + name + " Average price: " + avgPrice;
    }
}