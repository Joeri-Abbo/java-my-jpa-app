package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM Categories", Category.class);

            List<Category> categories = (List<Category>) query.getResultList();

            categories.forEach(System.out::println);

            query = entityManager.createNativeQuery("SELECT * FROM Products",Product.class);
            List<Product> products = (List<Product>) query.getResultList();

            products.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
