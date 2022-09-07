package com.skillsoft.jpa;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaQuery<Object[]> productCQ = cb.createQuery(Object[].class);
            Root<Product> rootProduct = productCQ.from(Product.class);

            productCQ.multiselect(rootProduct.get("name"), rootProduct.get("price"));

            TypedQuery<Object[]> productQuery = entityManager.createQuery(productCQ);

            productQuery.getResultList().forEach(r -> System.out.println(Arrays.toString(r)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
