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

            Invoice invoiceOne = new Invoice(699f);
            Invoice invoiceTwo = new Invoice(67f);

            Order orderOne = new Order("iPhone 6S", 1, new GregorianCalendar(2020, Calendar.FEBRUARY, 3).getTime());
            Order orderTwo = new Order("Nike Sneakers", 2, new GregorianCalendar(2020, Calendar.MARCH, 5).getTime());

            invoiceOne.setOrder(orderOne);
            invoiceTwo.setOrder(orderTwo);

            entityManager.persist(orderOne);
            entityManager.persist(orderTwo);

            entityManager.persist(invoiceOne);
            entityManager.persist(invoiceTwo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}
