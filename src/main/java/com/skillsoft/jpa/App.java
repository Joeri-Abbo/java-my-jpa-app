package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Category> categoryQuery = entityManager.createQuery("SELECT c FROM Categories c INNER JOIN FETCH c.products p WHERE c.name = ?1 AND p.price > ?2 ", Category.class);

            categoryQuery.setParameter(1, "Fashion");
            categoryQuery.setParameter(2, 60f);
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
