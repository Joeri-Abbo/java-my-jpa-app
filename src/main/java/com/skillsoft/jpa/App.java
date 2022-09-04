package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Long> categoryQuery = entityManager.createQuery("SELECT COUNT(c) FROM Categories c", Long.class);
            System.out.println(categoryQuery.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
