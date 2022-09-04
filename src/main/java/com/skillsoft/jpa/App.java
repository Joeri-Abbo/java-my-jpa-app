package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            Query aggQuery = entityManager.createQuery("SELECT c.name, AVG (p.price) FROM Categories c INNER JOIN c.products p GROUP BY c.name");

            @SuppressWarnings("unchecked")
            List<Object[]> resultList = aggQuery.getResultList();

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
