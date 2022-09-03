package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();


        try {
            entityManager.getTransaction().begin();

            Product productOne = new Product("iPhone 6S", 1);
            Product productTwo = new Product("Nike Sneakers", 1);

            List<Product> listOne = new ArrayList<>();
            listOne.add(productOne);
            listOne.add(productTwo);

            Order orderOne = new Order(listOne, new GregorianCalendar(2020, Calendar.FEBRUARY, 3).getTime());


            Product productThree = new Product("Samsung Galaxy", 1);
            Product productFour = new Product("Crocs", 1);
            Product productFive = new Product("BenQ Monitor", 1);

            List<Product> listTwo = new ArrayList<>();
            listTwo.add(productThree);
            listTwo.add(productFour);
            listTwo.add(productFive);
            Order orderTwo = new Order(listTwo, new GregorianCalendar(2020, Calendar.JUNE, 3).getTime());

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

            entityManager.close();
            factory.close();
        }
    }
}
