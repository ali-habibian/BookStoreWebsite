<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Category List - Bookstore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>Category Management</h2>
    <h3><a href="category_form.jsp">Create New Category</a></h3>
</div>

<div align="center">
    <h4><i>${message}</i></h4>
</div>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>

        <c:forEach items="${categoryList}" var="category" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <a href="edit_category?id=${category.id}">Edit</a> &nbsp;
                    <a href="javascript:confirmDelete(${category.id})">Delete</a>
                </td>
            </tr>
        </c:forEach>
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
