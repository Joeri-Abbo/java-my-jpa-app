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

            CriteriaQuery<Product> productCQ = cb.createQuery(Product.class);
            Root<Product> rootProduct = productCQ.from(Product.class);

            productCQ.select(rootProduct)
                    .where(cb.greaterThan(rootProduct.get("price"), 5));

            TypedQuery<Product> productQuery = entityManager.createQuery(productCQ);
            System.out.println(productQuery.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
