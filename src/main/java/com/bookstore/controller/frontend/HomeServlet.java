package com.bookstore.controller.frontend;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "")
public class HomeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO(entityManager);
        List<Category> categoryList = categoryDAO.listAll();
        request.setAttribute("categoryList", categoryList);

        String homePage = "frontend/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
        dispatcher.forward(request, response);
    }
}
