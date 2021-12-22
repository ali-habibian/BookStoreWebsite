package com.bookstore.controller.admin.user;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListUsersServlet", value = "/admin/user_list")
public class ListUsersServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService(entityManager, request, response);
        userService.listUser();
    }
}
