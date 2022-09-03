package com.skillsoft.jpa;

import java.util.*;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

//            Employee alice = new Employee("Alice");
//            Employee ben = new Employee("Ben");
//            Employee cora = new Employee("Cora");
//            Employee dennis = new Employee("Dennis");
//
//            Department engineering = new Department("Engineering");
//            engineering.addEmployee(alice);
//            engineering.addEmployee(ben);
//
//            Department sales = new Department("Sales");
//            sales.addEmployee(cora);
//            sales.addEmployee(dennis);

//            entityManager.persist(engineering);
//            entityManager.persist(sales);

            Department sales = entityManager.find(Department.class, 2);

            Employee elsa = new Employee("Elsa");
            sales.addEmployee(elsa);
            entityManager.merge(sales);

            Department engineering = entityManager.find(Department.class, 1);

            Employee fred = new Employee("Fred");
            engineering.addEmployee(fred);
            entityManager.merge(engineering);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();

        }
    }
}
