package com.bookstore.service;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.userDAO = new UserDAO(entityManager);
    }

    public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> usersList = userDAO.listAll();
        request.setAttribute("users", usersList);

        String listPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

        requestDispatcher.forward(request, response);
    }

    public void createUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        Users user = new Users(email, fullName, password);

        userDAO.create(user);
    }
}
