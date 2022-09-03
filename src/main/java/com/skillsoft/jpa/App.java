package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
//            Query categoryQuery = entityManager.createQuery("SELECT c FROM Categories c");
//
//            List<?> categories = categoryQuery.getResultList();
//
//            categories.forEach(System.out::println);
//
//            Query productQuery = entityManager.createQuery("SELECT p FROM Products p");
//            List<?> products = productQuery.getResultList();
//
//            products.forEach(System.out::println);
//
//
//            System.out.println("Position of first result: " + categoryQuery.getFirstResult());
//            System.out.println("Max result retrieved: " + categoryQuery.getMaxResults());
//
//            @SuppressWarnings("unchecked") List<Category> categoryList = (List<Category>) categoryQuery.getResultList();
//
//            System.out.println(categoryList);

            TypedQuery<Product> productQuery = entityManager.createQuery(
                    "SELECT p FROM Products p", Product.class
            );

            List<Product> productList = productQuery.getResultList();
            System.out.println(productList);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
