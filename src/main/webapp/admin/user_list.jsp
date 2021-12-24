<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>User List - Bookstore Administration</title>
</head>
<body class="container text-center">
<jsp:directive.include file="header.jsp"/>

<div class="row text-center">
    <h2 class="mt-4">User Management</h2>
    <h3 class="mt-2"><a class="btn btn-dark text-white" href="user_form.jsp">Create New User</a></h3>
</div>

<div>
    <h4><i>${message}</i></h4>
</div>

<div class="row mx-auto col-7">
    <table class="table text-center">
        <thead class="table-dark">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.userId}</td>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
                <td>
                    <a class="btn btn-dark text-white" href="edit_user?id=${user.userId}">Edit</a>
                    <a class="btn btn-dark text-white" href="javascript:confirmDelete(${user.userId})">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:directive.include file="footer.jsp"/>

<script>
    function confirmDelete(userId) {
        if (confirm("Are you sure you want to delete the user with ID " + userId + "?")) {
            window.location = "delete_user?id=" + userId;
        }
    }
</script>
</body>
</html>
