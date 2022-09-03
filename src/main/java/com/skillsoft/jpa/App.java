package com.skillsoft.jpa;

import javax.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            FullTimeEmployee alice = new FullTimeEmployee("Alice", 50000);
            FullTimeEmployee ben = new FullTimeEmployee("Ben", 45000);

            ContractEmployee cora = new ContractEmployee("Cora", 50);
            ContractEmployee dennis = new ContractEmployee("Dennis", 60);

            Department engineering = new Department("Engineering");
            engineering.addEmployee(alice);
            engineering.addEmployee(ben);

            Vendor admin = new Vendor("Administrative");
            admin.addEmployee(cora);
            admin.addEmployee(dennis);

            entityManager.persist(engineering);
            entityManager.persist(admin);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();
        }
    }
}
