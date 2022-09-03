package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Product> productQuery = entityManager.createQuery("SELECT p FROM Products p WHERE p.name LIKE :nameStartsWith", Product.class);
            productQuery.setParameter("nameStartsWith", "iPh%");
            List<Product> products = productQuery.getResultList();
            System.out.println(products);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
