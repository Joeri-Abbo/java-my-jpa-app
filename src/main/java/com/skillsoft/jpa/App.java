package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Category> categoryQuery = entityManager.createNamedQuery(Category.SELECT_SPECIFIC_CATEGORY, Category.class);
            categoryQuery.setParameter("categoryName", "Fashion");
            System.out.println(categoryQuery.getSingleResult());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
