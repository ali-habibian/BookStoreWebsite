package com.bookstore.dao;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest extends BaseDAOTest{

    private static CategoryDAO categoryDAO;

    @BeforeAll
    static void setUpClass() {
        BaseDAOTest.setUp();
        categoryDAO = new CategoryDAO(entityManager);
    }

    @AfterAll
    static void tearDownClass() {
        BaseDAOTest.tearDown();
    }

    @Test
    void test_create_category() {
        Category newCat = new Category("Java");
        Category category = categoryDAO.create(newCat);

        assertTrue(category != null && category.getId() > 0);
    }

    @Test
    void test_create_user_fields_not_set() {
        Category category = new Category();

        assertThrows(PersistenceException.class, () -> categoryDAO.create(category));
    }

    @Test
    void test_update_category() {
        Category category = new Category();
        category.setId(1);
        category.setName("Up_Java");

        category = categoryDAO.update(category);

        String expected = "Up_Java";
        String actual = category.getName();

        assertEquals(expected, actual);
    }

    @Test
    void test_get_exist_category() {
        Integer categoryId = 1;
        Category category = categoryDAO.get(categoryId);
        if (category != null)
            System.out.println(category.getName());

        assertNotNull(category);
    }

    @Test
    void test_get_not_exist_category() {
        Integer categoryId = 99;
        Category category = categoryDAO.get(categoryId);

        if (category != null)
            System.out.println(category.getName());

        assertNull(category);
    }

    @Test
    void test_delete_exist_category() {
        Integer categoryId = 1;
        categoryDAO.delete(categoryId);

        Category category = categoryDAO.get(categoryId);

        assertNull(category);
    }

    @Test
    void test_delete_not_exist_category() {
        Integer categoryId = 91;
        assertThrows(EntityNotFoundException.class, () -> categoryDAO.delete(categoryId));
    }

    @Test
    void test_list_all_categories() {
        List<Category> categories = categoryDAO.listAll();
        categories.forEach(c -> System.out.println(c.getName()));
        assertTrue(categories.size() > 0);
    }

    @Test
    void test_count() {
        long count = categoryDAO.count();

        assertEquals(2, count);
    }

}