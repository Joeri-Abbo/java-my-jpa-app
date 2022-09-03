package com.skillsoft.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity(name = "Orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    @JoinTable(name = "order_product_mapping", joinColumns = {@JoinColumn(name = "o_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "p_id", referencedColumnName = "id")})
    private List<Product> products;
    private Integer quantity;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @OneToOne
    @JoinTable(name = "order_invoice", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "invoice_id", referencedColumnName = "id")})
    private Invoice invoice;

    public Order() {

    }

    public Order(List<Product> products, Date orderDate) {
        this.products = products;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
        return "\n{" + id + ", " + products + ", " + quantity + "}\n";
    }
}
