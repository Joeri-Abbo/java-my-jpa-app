package com.skillsoft.jpa;

import java.util.*;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UniversityDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Map<Integer, String> listSarah = new HashMap<>();

            listSarah.put(141, "Data Structures and Algorithms");
            listSarah.put(101, "Statistics");
            listSarah.put(104, "English");

            Map<Integer, String> listTom = new HashMap<>();
            listTom.put(40, "Geology");
            listTom.put(90, "Math");

            Student studentSarah = new Student("Sarah", listSarah);
            Student studentTom = new Student("Tom", listTom);

            entityManager.persist(studentSarah);
            entityManager.persist(studentTom);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
