package com.bookstore.dao;

import com.bookstore.entity.Users;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAO userDAO;

    @BeforeAll
    static void setUpClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }

    @Test
    void test_create_user() {
        Users user = new Users();
        user.setFullName("User Test");
        user.setEmail("test@mail.com");
        user.setPassword("12345");

        user = userDAO.create(user);

        assertTrue(user.getUserId() > 0);
    }

    @Test
    void test_create_user_fields_not_set() {
        Users user = new Users();

        assertThrows(PersistenceException.class, () -> userDAO.create(user));
    }

    @Test
    void test_update_user() {
        Users user = new Users();
        user.setUserId(22);
        user.setEmail("Bahram@mail.com");
        user.setFullName("Bahram Mahdi");
        user.setPassword("testPass");

        user = userDAO.update(user);

        String expected = "testPass";
        String actual = user.getPassword();

        assertEquals(expected, actual);
    }

    @AfterAll
    static void tearDownClass() {
        entityManager.close();
        entityManagerFactory.close();
    }
}