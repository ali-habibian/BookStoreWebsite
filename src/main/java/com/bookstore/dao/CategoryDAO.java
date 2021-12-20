package com.bookstore.dao;

import com.bookstore.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {
    public CategoryDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Category get(Object categoryId) {
        return super.find(Category.class, categoryId);
    }

    @Override
    public void delete(Object categoryId) {
        super.delete(Category.class, categoryId);
    }

    @Override
    public List<Category> listAll() {
        return super.findWithNamedQuery("Category.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Category.countAll");
    }

    public Category findByName(String categoryName) {
        List<Category> categoryList = findWithNamedQuery("Category.findByName", "name", categoryName);

        if (categoryList != null && categoryList.size() > 0) {
            return categoryList.get(0);
        }
        return null;
    }
}
