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

//            Book bookOne = entityManager.find(Book.class, 221);
//            System.out.println(bookOne);
//
//            Book bookTwo = entityManager.find(Book.class, 251);
//            System.out.println(bookTwo);
//
//            Book bookThree = entityManager.find(Book.class,281);
//            System.out.println(bookThree);

            List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();

            System.out.println(books);

        } catch (Exception e) {
            System.out.println("An exception occurred: " + e);
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
