<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 12/2/2021
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--<jsp:directive.include file="header.jsp"/>--%>
<jsp:include page="header.jsp"/>
<br/><br/>

<div align="center">
    <h2>Please Login:</h2>
    <form>
        Email: <label><input type="text" size="10"></label><br/>
        Password: <label><input type="password" size="10"></label><br/>
        <input type="submit" value="Login">
    </form>
</div>

<br/><br/>
<jsp:include page="footer.jsp"/>
</body>
</html>