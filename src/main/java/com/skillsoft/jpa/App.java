package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Department operations = entityManager.find(Department.class, 2);
            operations.setName("Operations");

            Employee elise = new Employee("Elise");
            operations.addEmployee(elise);
            entityManager.merge(operations);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();
        }
    }
}
