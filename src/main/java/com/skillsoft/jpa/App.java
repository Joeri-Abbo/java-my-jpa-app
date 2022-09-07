package com.skillsoft.jpa;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            Department tech = entityManager.find(Department.class, 1);
            System.out.println(tech);
            Department operations = entityManager.find(Department.class, 2);
            System.out.println(operations);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}
