package com.skillsoft.jpa;

import java.util.*;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

//        try {
//            entityManager.getTransaction().begin();
//
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
//
//            entityManager.persist(engineering);
//            entityManager.persist(sales);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            entityManager.getTransaction().commit();
//            entityManager.close();
//            factory.close();
//
//        }

        try {
            entityManager.getTransaction().begin();
//            Department sales = entityManager.find(Department.class, 2);
//            entityManager.remove(sales);

            Department engineering = entityManager.find(Department.class, 1);
            entityManager.remove(engineering);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
        factory.close();
        }


    }
}
