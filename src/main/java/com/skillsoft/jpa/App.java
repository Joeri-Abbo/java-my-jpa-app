package com.skillsoft.jpa;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
//            FullTimeEmployee alice = new FullTimeEmployee("Alice", 50000);
//            FullTimeEmployee ben = new FullTimeEmployee("Ben", 45000);
//
//            ContractEmployee cora = new ContractEmployee("Cora", 50);
//            ContractEmployee dennis = new ContractEmployee("Dennis", 60);
//
//            Department engineering = new Department("Engineering");
//            engineering.addEmployee(alice);
//            engineering.addEmployee(ben);
//
//            Vendor admin = new Vendor("Administrative");
//            admin.addEmployee(cora);
//            admin.addEmployee(dennis);
//
//            entityManager.persist(engineering);
//            entityManager.persist(admin);

            FullTimeEmployee alice = entityManager.find(FullTimeEmployee.class, 1);
            System.out.println(alice.getName());
            System.out.println(alice.getSalary());


            ContractEmployee cora = entityManager.find(ContractEmployee.class, 3);
            System.out.println(cora.getName());
            System.out.println(cora.getHourlyPay());

            Employee zoe = entityManager.find(Employee.class, 333);
            System.out.println("\n\nemployee_type is null: " + zoe.getName());

            UnknownEmployee zara = entityManager.find(UnknownEmployee.class, 222);
            System.out.println("\n\nemployee_type is not a known value: " + zara.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();
        }
    }
}
