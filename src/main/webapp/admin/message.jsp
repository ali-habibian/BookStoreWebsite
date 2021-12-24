<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 12/16/2021
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Bookstore Administration</title>
</head>
<body class="container text-center position-relative">
<jsp:directive.include file="header.jsp"/>

<div class="row mt-5 mb-5 p-5 text-center">
    <h3>${message}</h3>
</div>


<jsp:directive.include file="footer.jsp"/>
</body>
</html>
