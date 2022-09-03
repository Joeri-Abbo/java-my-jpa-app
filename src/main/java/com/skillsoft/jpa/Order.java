package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String product;
    private Integer quantity;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public Order() {

    }

    public Order(String product, Integer quantity, Date orderDate) {
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String toString() {
        return "\n{" + id + ", " + product + ", " + quantity + "}\n";
    }
}
