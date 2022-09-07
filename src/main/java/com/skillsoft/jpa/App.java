package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<Department> deptQuery = entityManager.createQuery("SELECT d FROM departments d", Department.class);

            List<Department> departmentList = deptQuery.getResultList();
            System.out.println(departmentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}
