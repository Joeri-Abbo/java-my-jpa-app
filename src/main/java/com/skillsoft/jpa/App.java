package com.skillsoft.jpa;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Category> categoryCQ = cb.createQuery(Category.class);
            Root<Category> rootCategory = categoryCQ.from(Category.class);

            categoryCQ.select(rootCategory);
            TypedQuery<Category> categoryQuery = entityManager.createQuery(categoryCQ);
            System.out.println(categoryQuery.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
