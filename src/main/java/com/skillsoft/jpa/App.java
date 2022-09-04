package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            TypedQuery<CategoryPrice> aggQuery = entityManager.createQuery(
                    "SELECT NEW com.skillsoft.jpa.CategoryPrice(c.name, AVG(p.price)) " +
                            "FROM Categories c " +
                            "INNER JOIN c.products p GROUP BY c.name", CategoryPrice.class
            );

            @SuppressWarnings("unchecked")
            List<CategoryPrice> resultList = aggQuery.getResultList();

            System.out.println();
            resultList.forEach(r -> System.out.println(r));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }
    }
}
