package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            Query categoryQuery = entityManager.createNamedQuery("selectSpecificCategory");
            categoryQuery.setParameter("categoryName", "Fashion");
            System.out.println(categoryQuery.getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
