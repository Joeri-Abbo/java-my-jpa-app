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

        }

        try {
            Student s1 = entityManager.find(Student.class, 1);
            System.out.println(s1);
            System.out.println(s1.getCourses());

            Student s2 = entityManager.find(Student.class, 2);
            System.out.println(s2);
            System.out.println(s2.getCourses());

        } catch (Exception e) {
            e.printStackTrace();
        }

        entityManager.close();
        factory.close();
    }
}
