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
//            alice.setDepartment(engineering);
//
//            ContractEmployee cora = new ContractEmployee("Cora", 50);
//            cora.setDepartment(engineering);
//
//            Employee elsa = new Employee("Elsa");
//            engineering.addEmployee(elsa);
//
//            entityManager.persist(alice);
//            entityManager.persist(cora);
//            entityManager.persist(engineering);

            List<Employee> employees = (List<Employee>) entityManager.createQuery("from employees", Employee.class).getResultList();

            for (Employee e : employees) {
                System.out.println(e.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
