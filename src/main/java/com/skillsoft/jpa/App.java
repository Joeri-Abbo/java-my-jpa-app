package com.skillsoft.jpa;

import java.util.*;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Employee alice = new Employee("Alice");
            Employee ben = new Employee("Ben");
            Employee cora = new Employee("Cora");
            Employee dennis = new Employee("Dennis");

            Department engineering = new Department("Engineering");
            engineering.addEmployee(alice);
            engineering.addEmployee(ben);

            Department sales = new Department("Sales");
            sales.addEmployee(cora);
            sales.addEmployee(dennis);

            entityManager.persist(engineering);
            entityManager.persist(sales);

            entityManager.persist(alice);
            entityManager.persist(ben);
            entityManager.persist(cora);
            entityManager.persist(dennis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();
        }
    }
}
