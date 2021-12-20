package com.bookstore.dao;

import com.bookstore.entity.Users;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

import java.util.List;

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
        user.setFullName("User Test 3");
        user.setEmail("test_3@mail.com");
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

    @Test
    void test_get_user_found() {
        Integer userId = 1;
        Users user = userDAO.get(userId);
        if (user != null)
            System.out.println(user.getEmail());

        assertNotNull(user);
    }

    @Test
    void test_get_user_not_found() {
        Integer userId = 99;
        Users user = userDAO.get(userId);

        if (user != null)
            System.out.println(user.getEmail());

        assertNull(user);
    }

    @Test
    void test_delete_exist_user() {
        Integer userId = 1;
        userDAO.delete(userId);

        Users user = userDAO.get(userId);

        assertNull(user);
    }

    @Test
    void test_delete_not_exist_user() {
        Integer userId = 99;
        assertThrows(EntityNotFoundException.class, () -> userDAO.delete(userId));
    }

    @Test
    void test_list_all_users(){
        List<Users> users = userDAO.listAll();
        users.forEach(u -> System.out.println(u.getFullName()));
        assertTrue(users.size() > 0);
    }

    @Test
    void test_findByEmail_user_not_exist() {
        String email = "ali@mailll.com";
        Users user = userDAO.findByEmail(email);

        assertNull(user);
    }

    @Test
    void test_findByEmail_user_exist() {
        String email = "test_7@mail.com";
        Users user = userDAO.findByEmail(email);

        assertNotNull(user);
    }

    @Test
    void test_count() {
        long count = userDAO.count();

        assertEquals(8, count);
    }

    @AfterAll
    static void tearDownClass() {
        entityManager.close();
        entityManagerFactory.close();
    }
}