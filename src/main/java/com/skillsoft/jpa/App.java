package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            Book bookOne = entityManager.find(Book.class, 221);
            Book bookTwo = entityManager.find(Book.class, 251);
            System.out.println(bookOne);
            System.out.println(bookTwo);

            entityManager.getTransaction().begin();

            if (bookOne!= null){
                entityManager.remove(bookOne);
            }
            if (bookTwo!= null){
                entityManager.remove(bookTwo);
            }

        } catch (Exception e) {
            System.out.println("An exception occurred: " + e);
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
