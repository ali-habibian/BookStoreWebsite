<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 12/6/2021
  Time: 12:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New User - Bookstore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>Create New User</h2>
</div>

<div align="center">
    <form action="create_user" method="post" onsubmit="return validateFormInput()">
        <table cellpadding="5">
            <tr>
                <td>Email:</td>
                <td><label for="email"><input id="email" type="text" name="email" size="20"></label></td>
            </tr>

            <tr>
                <td>Full Name:</td>
                <td><label for="fullName"><input id="fullName" type="text" name="fullname" size="20"></label></td>
            </tr>

            <tr>
                <td>Password:</td>
                <td><label for="password"><input id="password" type="password" name="password" size="20"></label>
                </td>
            </tr>

            <tr><td>&nbsp;</td></tr>

            <tr>
                <td colspan="2" align="center">
                    <label for="btn_save_id"><input id="btn_save_id" type="submit" value="Save" size="20"></label>
                    <label for="btn_cancel_id"><input id="btn_cancel_id" type="button" value="Cancel" onclick="history.go(-1)"></label>
                </td>
            </tr>
        </table>
    </form>
</div>

<jsp:directive.include file="footer.jsp"/>
</body>

<script>
    function validateFormInput(){
        const fieldEmail = document.getElementById("email");
        const fieldFullName = document.getElementById("fullName");
        const fieldPassword = document.getElementById("password");

        if (fieldEmail.value.length === 0){
            alert("Email is required!");
            fieldEmail.focus();
            return false;
        }

        if (fieldFullName.value.length === 0){
            alert("Full Name is required!");
            fieldEmail.focus();
            return false;
        }

        if (fieldPassword.value.length === 0){
            alert("Password is required!");
            fieldEmail.focus();
            return false;
        }
    }
</script>

</html>
