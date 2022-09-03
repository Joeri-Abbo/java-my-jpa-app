package com.skillsoft.jpa;

import java.util.*;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UniversityDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Map<Integer, Course> mapSarah = new HashMap<>();

            mapSarah.put(141, new Course("Intermediate", "Data Structures and Algorithms"));
            mapSarah.put(101, new Course("Basic", "Statistics"));
            mapSarah.put(104, new Course("Basic", "English"));

            Map<Integer, Course> mapTom = new HashMap<>();
            mapTom.put(40, new Course("Intermediate", "Geology"));
            mapTom.put(90, new Course("Advanced", "Math"));

            Student studentSarah = new Student("Sarah", mapSarah);
            Student studentTom = new Student("Tom", mapTom);

            entityManager.persist(studentSarah);
            entityManager.persist(studentTom);

            for(Course course: mapSarah.values()){
                entityManager.persist(course);
            }
            for (Course course : mapTom.values()) {
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
