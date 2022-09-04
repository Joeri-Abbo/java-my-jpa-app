package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Category> categoryQuery = entityManager.createQuery("SELECT c FROM Categories c INNER JOIN FETCH c.products p WHERE p.name IN (?1, ?2, ?3)", Category.class);

            categoryQuery.setParameter(1, "Samsung Galaxy");
            categoryQuery.setParameter(2, "Jeans");
            categoryQuery.setParameter(3, "Notebook");
            List<Category> categories = categoryQuery.getResultList();
            System.out.println(categories);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
