<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Category List - Bookstore Administration</title>
</head>
<body class="container text-center">
<jsp:directive.include file="header.jsp"/>

<div class="row text-center">
    <h2 class="mt-4">Category Management</h2>
    <h3 class="mt-2"><a class="btn btn-dark text-white" href="category_form.jsp">Create New Category</a></h3>
</div>

<div>
    <h4><i>${message}</i></h4>
</div>

<div class="row mx-auto col-5">
    <table class="table text-center">
        <thead class="table-dark">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categoryList}" var="category" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <a class="btn btn-dark text-white" href="edit_category?id=${category.id}">Edit</a> &nbsp;
                    <a class="btn btn-dark text-white" href="javascript:confirmDelete(${category.id})">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:directive.include file="footer.jsp"/>

<script>
    function confirmDelete(categoryId) {
        if (confirm("Are you sure you want to delete the category with ID " + categoryId + "?")) {
           window.location = "delete_category?id=" + categoryId;
        }
    }
</script>
</body>
</html>
