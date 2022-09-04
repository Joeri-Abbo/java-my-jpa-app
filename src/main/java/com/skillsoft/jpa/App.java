package com.skillsoft.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShippingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            Query query = entityManager.createQuery("SELECT c.name, c.id FROM Categories c WHERE EXISTS (SELECT p FROM Products p WHERE p.price > ?1 AND p.category.id = c.id)");
            query.setParameter(1, 50f);


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
