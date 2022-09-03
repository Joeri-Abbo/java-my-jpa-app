package com.skillsoft.jpa;

import java.util.*;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UniversityDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Map<Course, Integer> mapSarah = new HashMap<>();

            mapSarah.put(new Course("Intermediate", "Data Structures and Algorithms"), 141);
            mapSarah.put(new Course("Basic", "Statistics"), 101);
            mapSarah.put(new Course("Basic", "English"), 104);

            Map<Course, Integer> mapTom = new HashMap<>();
            mapTom.put(new Course("Intermediate", "Geology"), 40);
            mapTom.put(new Course("Advanced", "Math"), 90);

            Student studentSarah = new Student("Sarah", mapSarah);
            Student studentTom = new Student("Tom", mapTom);

            entityManager.persist(studentSarah);
            entityManager.persist(studentTom);

            for (Course course : mapSarah.keySet()) {
                entityManager.persist(course);
            }
            for (Course course : mapTom.keySet()) {
                entityManager.persist(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
