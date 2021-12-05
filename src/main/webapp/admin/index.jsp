<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 11/27/2021
  Time: 1:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookstore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>Administrative Dashboard</h2>
</div>

<div align="center">
    <hr width="60%"/>

    <div>
        <h2><b>Quick Actions:</b></h2>
        <b>
            <a href="#">New Book</a> |
            <a href="#">New User</a> |
            <a href="#">New Category</a> |
            <a href="#">New Customer</a>
        </b>
    </div>
</div>

<div align="center">
    <hr width="60%"/>

    <div>
        <h2><b>Recent Sales:</b></h2>
    </div>
</div>

<div align="center">
    <hr width="60%"/>

    <div>
        <h2><b>Recent Reviews:</b></h2>
    </div>
</div>

<div align="center">
    <hr width="60%"/>

    <div>
        <h2><b>Statics:</b></h2>
    </div>

    <hr width="60%"/>
</div>

<jsp:directive.include file="footer.jsp"/>
</body>
</html>
