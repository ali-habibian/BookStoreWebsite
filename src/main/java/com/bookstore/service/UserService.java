package com.bookstore.service;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserService {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private final UserDAO userDAO;

    public UserService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.userDAO = new UserDAO(entityManager);
    }

    public List<Users> listUser(){
         return userDAO.listAll();
    }
}
