package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Query updateQuery = entityManager.createQuery("UPDATE Products p SET p.name = 'Gel Pens' WHERE p.name = :name");

            updateQuery.setParameter("name", "Pen");

            int rowsUpdated = updateQuery.executeUpdate();

            System.out.println("\n\nNumber of rows updated: " + rowsUpdated);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
