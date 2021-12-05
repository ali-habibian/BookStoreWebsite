package com.bookstore.controller.admin;

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
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<Users> usersList = userService.listUser();
        request.setAttribute("users", usersList);

        String listPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

        requestDispatcher.forward(request, response);
    }
}
