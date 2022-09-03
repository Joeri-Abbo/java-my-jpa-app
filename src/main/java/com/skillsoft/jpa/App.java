package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Product> productQuery = entityManager.createQuery("SELECT p FROM Products p WHERE p.id = ?1", Product.class);
            productQuery.setParameter(1, 1005);
            Product product = productQuery.getSingleResult();
            System.out.println(product);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
