<%--
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
    <title>Ali Bookstore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>User Management</h2>
    <h3><a href="#">Create New User</a></h3>
</div>

<div align="center">
    <table border="1">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Actions</th>
        </tr>

        <c:forEach items="a,b,c" var="user" varStatus="status">
            <tr>
                <td><c:out value="${status.index + 1}"/></td>
                <td><c:out value="${user}"/></td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:directive.include file="footer.jsp"/>
</body>
</html>
