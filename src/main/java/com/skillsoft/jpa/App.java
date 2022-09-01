package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Book firstBook = new Book("The Java Language Specification", "Gilad Bracha", 99f);
            Book secondBook = new Book("The Java Language Specification Second Edition", "Gilad Bracha, James Gosling", 119f);
            Book thirdBook = new Book("Core Java Volume I", "Cay S. Horstmann", 59f);

            entityManager.persist(firstBook);
            entityManager.persist(secondBook);
            entityManager.persist(thirdBook);

            Author firstAuthor = new Author("Gilad Bracha", new GregorianCalendar(1980, Calendar.FEBRUARY, 0).getTime());
            Author secondAuthor = new Author("James Gosling", new GregorianCalendar(1975, Calendar.MARCH, 0).getTime());

            entityManager.persist(firstAuthor);
            entityManager.persist(secondAuthor);

        } catch (Exception e) {
            System.out.println("An exception occurred: " + e);
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}
