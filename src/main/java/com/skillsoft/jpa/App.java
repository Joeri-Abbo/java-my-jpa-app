package com.skillsoft.jpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UniversityDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Set<Course> listSarah = new HashSet<>();

            listSarah.add(new Course("CS141", "Data Structures and Algorithms"));
            listSarah.add(new Course("STAT101", "Statistics"));
            listSarah.add(new Course("EN104", "English"));

            Set<Course> listTom = new HashSet<>();
            listTom.add(new Course("GEO40", "Geology"));
            listTom.add(new Course("MATH90", "Math"));

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
