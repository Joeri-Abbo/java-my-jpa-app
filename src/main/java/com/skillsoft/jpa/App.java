package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Order orderOne = new Order(new GregorianCalendar(2020, Calendar.FEBRUARY, 3).getTime());
            Product productOne = new Product(orderOne, "iPhone 6S", 1);
            Product productTwo = new Product(orderOne, "Nike Sneakers", 1);


            Order orderTwo = new Order(new GregorianCalendar(2020, Calendar.JUNE, 3).getTime());
            Product productThree = new Product(orderTwo, "Samsung Galaxy", 1);
            Product productFour = new Product(orderTwo, "Crocs", 1);
            Product productFive = new Product(orderTwo, "BenQ Monitor", 1);

            entityManager.persist(orderOne);
            entityManager.persist(orderTwo);

            entityManager.persist(productOne);
            entityManager.persist(productTwo);
            entityManager.persist(productThree);
            entityManager.persist(productFour);
            entityManager.persist(productFive);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

        }

        try {
            Product productOne = entityManager.find(Product.class, 1);
            System.out.println(productOne);
            System.out.println(productOne.getOrder());

            Product productFive = entityManager.find(Product.class, 5);
            System.out.println(productFive);
            System.out.println(productFive.getOrder());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}
