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
import java.util.Objects;

public class UserService {
    private final UserDAO userDAO;

    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserService(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

        this.userDAO = new UserDAO(entityManager);
        this.request = request;
        this.response = response;
    }

    public void listUser()
            throws ServletException, IOException {
        listUser(null);
    }

    public void listUser(String message)
            throws ServletException, IOException {
        List<Users> usersList = userDAO.listAll();
        request.setAttribute("users", usersList);

        if (message != null)
            request.setAttribute("message", message);

        String listPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

        requestDispatcher.forward(request, response);
    }

    public void createUser() throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        Users existUser = userDAO.findByEmail(email);

        if (existUser != null) {
            String message = "Could not create user. A user with email " + email + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request, response);
        } else {
            Users user = new Users(email, fullName, password);
            userDAO.create(user);
            listUser("New user created successfully");
        }
    }

    public void editUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        Users user = userDAO.get(userId);

        String editPage = "user_form.jsp";
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
        dispatcher.forward(request, response);
    }

    public void updateUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        Users userById = userDAO.get(userId);
        Users userByEmail = userDAO.findByEmail(email);

        if (userByEmail != null && !Objects.equals(userByEmail.getUserId(), userById.getUserId())) {
            String message = "Could not update user. User with email " + email + " already exists.";
            request.setAttribute("message", message);

            String editPage = "message.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
            dispatcher.forward(request, response);
        } else {
            Users user = new Users(userId, email, fullName, password);
            userDAO.update(user);

            String message = "User has been updated successfully";
            listUser(message);
        }
    }

    public void deleteUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(userId);
        String message = "User has been deleted successfully.";
        listUser(message);
    }
}
