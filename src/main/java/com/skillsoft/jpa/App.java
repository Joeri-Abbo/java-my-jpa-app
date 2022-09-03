package com.skillsoft.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UniversityDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            List<String> listSarah = new ArrayList<>();

            listSarah.add("Data Structures and Algorithms");
            listSarah.add("Statistics");
            listSarah.add("English");
            listSarah.add("Data Structures and Algorithms");

            List<String> listTom = new ArrayList<>();
            listTom.add("Geology");
            listTom.add("Math");

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
