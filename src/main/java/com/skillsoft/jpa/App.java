package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            Query query = entityManager.createQuery("SELECT p.name, p.price, " +
                    "CASE p.category.id " +
                    "WHEN 221 THEN 'Mobile Phones'" +
                    "WHEN 241 THEN 'Home and Kitchen'" +
                    "ELSE p.category.name END " +
                    "FROM Products p");

            @SuppressWarnings("unchecked") List<Object[]> resultList = query.getResultList();

            System.out.println();
            resultList.forEach(r -> System.out.println(Arrays.toString(r)));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
