package com.skillsoft.jpa;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Department sales = entityManager.find(Department.class, 2);
//            Employee cora = entityManager.find(Employee.class, 3);
//            Employee alice = entityManager.find(Employee.class, 1);
//
//            entityManager.detach(sales);
//
//            System.out.println("Is sales attached:"+ entityManager.contains(sales));
//            System.out.println("Is Cora attached:"+ entityManager.contains(cora));
//            System.out.println("Is Alice attached:"+ entityManager.contains(alice));

            entityManager.remove(sales);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();

        }
    }
}
