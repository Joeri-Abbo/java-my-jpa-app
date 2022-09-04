package com.skillsoft.jpa;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Product> productQuery1 = entityManager.createNamedQuery(Product.PRODUCTS_IN_CATEGORY, Product.class);
            productQuery1.setParameter("categoryId", 231);
            System.out.println(productQuery1.getResultList());

            TypedQuery<Product> productQuery2 = entityManager.createNamedQuery(Product.PRODUCTS_IN_PRICE_RANGE, Product.class);
            productQuery2.setParameter("low", 100f);
            productQuery2.setParameter("high", 1000f);
            System.out.println(productQuery2.getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
