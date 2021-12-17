<%@ page import="com.bookstore.entity.Users" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 12/5/2021
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User List - Bookstore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>User Management</h2>
    <h3><a href="user_form.jsp">Create New User</a></h3>
</div>

<div align="center">
    <h4><i>${message}</i></h4>
</div>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Actions</th>
        </tr>

        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.userId}</td>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
                <td>
                    <a href="edit_user?id=${user.userId}">Edit</a> &nbsp;
                    <a href="#">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:directive.include file="footer.jsp"/>
</body>
</html>
