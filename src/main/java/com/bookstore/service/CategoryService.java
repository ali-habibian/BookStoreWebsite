package com.bookstore.service;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Category;

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

public class CategoryService {
    private final CategoryDAO categoryDAO;

    private HttpServletRequest request;
    private HttpServletResponse response;

    public CategoryService(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
        this.categoryDAO = new CategoryDAO(entityManager);
        this.request = request;
        this.response = response;
    }

    public void listCategory() throws ServletException, IOException {
        listCategory(null);
    }

    public void listCategory(String message) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.listAll();
        request.setAttribute("categoryList", categoryList);

        if (message != null)
            request.setAttribute("message", message);

        String listPage = "category_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);
    }

    public void createCategory() throws ServletException, IOException {
        String categoryName = request.getParameter("name");

        Category existCategory = categoryDAO.findByName(categoryName);
        if (existCategory != null) {
            String message = "Could not create category. A category with name " + categoryName + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request, response);
        } else {
            Category category = new Category(categoryName);
            categoryDAO.create(category);

            listCategory("New category created successfully");
        }
    }

    public void editCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDAO.get(categoryId);
        request.setAttribute("category", category);

        String editPage = "category_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request, response);
    }

    public void updateCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String categoryName = request.getParameter("name");

        Category categoryById = categoryDAO.get(categoryId);
        Category categoryByName = categoryDAO.findByName(categoryName);
        if (categoryByName != null && !Objects.equals(categoryById.getId(), categoryByName.getId())) {
            String message = "Could not update category. A category with name " + categoryName + " already exists.";
            request.setAttribute("message", message);

            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        } else {
            categoryById.setName(categoryName);
            categoryDAO.update(categoryById);
            String message = "Category has been updated successfully";
            listCategory(message);
        }
    }
}
