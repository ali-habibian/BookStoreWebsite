package com.bookstore.controller.admin.user;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.entity.Users;
import com.bookstore.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListUsersServlet", value = "/admin/user_list")
public class ListUsersServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService(entityManager, request, response);
        userService.listUser();
    }
}
