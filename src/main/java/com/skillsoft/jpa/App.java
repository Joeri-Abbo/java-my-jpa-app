package com.skillsoft.jpa;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaQuery<String> productCQ = cb.createQuery(String.class);
            Root<Product> rootProduct = productCQ.from(Product.class);

            productCQ.select(rootProduct.get("name"));

            TypedQuery<String> productQuery = entityManager.createQuery(productCQ);

            productQuery.getResultList().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
