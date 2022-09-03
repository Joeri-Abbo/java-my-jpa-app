package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
//            entityManager.getTransaction().begin();
//
//            Department engineering = new Department("Engineering");
//
//            FullTimeEmployee alice = new FullTimeEmployee("Alice", 50000);
//            FullTimeEmployee ben = new FullTimeEmployee("Ben", 45000);
//
//            ContractEmployee cora = new ContractEmployee("Cora", 50);
//            ContractEmployee dennis = new ContractEmployee("Dennis", 60);
//
//            Employee elsa = new Employee("Elsa");
//
//            engineering.addEmployee(alice);
//            engineering.addEmployee(ben);
//            engineering.addEmployee(cora);
//            engineering.addEmployee(dennis);
//            engineering.addEmployee(elsa);
//
//            entityManager.persist(engineering);

            FullTimeEmployee ft = entityManager.find(FullTimeEmployee.class, 2);

            System.out.println();
            System.out.println(ft.getName() + " Salary: " + ft.getSalary());

            ContractEmployee ct = entityManager.find(ContractEmployee.class, 1);

            System.out.println();
            System.out.println(ct.getName() + " Hourly pay: " + ct.getHourlyPay());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
