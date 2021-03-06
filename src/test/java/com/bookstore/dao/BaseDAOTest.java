package com.bookstore.dao;

import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {
    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
