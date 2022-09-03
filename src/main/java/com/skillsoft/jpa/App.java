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
            Order orderOne = entityManager.find(Order.class, 1);
            System.out.println(orderOne);
            Order orderTwo = entityManager.find(Order.class, 2);
            System.out.println(orderTwo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}
