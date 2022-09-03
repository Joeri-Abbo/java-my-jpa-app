package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Product productOne = new Product("iPhone 6S");
            Product productTwo = new Product("Nike Sneakers");
            Product productThree = new Product("Samsung Galaxy");
            Product productFour = new Product("Crocs");
            Product productFive = new Product("BenQ Monitor");

            List<Product> listCustomerOne = new ArrayList<>();
            List<Product> listCustomerTwo = new ArrayList<>();
            List<Product> listCustomerThree = new ArrayList<>();

            listCustomerOne.add(productOne);
            listCustomerOne.add(productTwo);
            listCustomerOne.add(productThree);

            Customer customerOne = new Customer("John", listCustomerOne);

            listCustomerTwo.add(productOne);
            listCustomerTwo.add(productThree);

            Customer customerTwo = new Customer("Julie", listCustomerTwo);

            listCustomerThree.add(productOne);
            listCustomerThree.add(productThree);
            listCustomerThree.add(productFour);

            Customer customerThree = new Customer("Ben", listCustomerThree);


            entityManager.persist(customerOne);
            entityManager.persist(customerTwo);
            entityManager.persist(customerThree);

            entityManager.persist(productOne);
            entityManager.persist(productTwo);
            entityManager.persist(productThree);
            entityManager.persist(productFour);
            entityManager.persist(productFive);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

        }

        try {
            Customer customerOne = entityManager.find(Customer.class,1);
            System.out.println(customerOne);
            System.out.println(customerOne.getProducts());

            Customer customerThree = entityManager.find(Customer.class,3);
            System.out.println(customerThree);
            System.out.println(customerThree.getProducts());
        } catch (Exception e){
            e.printStackTrace();
        }

        entityManager.close();
        factory.close();
    }
}
