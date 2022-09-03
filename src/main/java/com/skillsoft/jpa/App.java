package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Product> productQuery = entityManager.createQuery("SELECT p FROM Products p WHERE p.category.id = :category_id", Product.class);
            productQuery.setParameter("category_id", 231);
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
