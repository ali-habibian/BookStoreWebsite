<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Create New User - Bookstore Administration</title>
</head>
<body class="container text-center">
<jsp:directive.include file="header.jsp"/>

<div class="row text-center">
    <h2 class="mt-4">
        <c:if test="${user != null}">Edit User</c:if>
        <c:if test="${user == null}">Create New User</c:if>
    </h2>
</div>

<div class="row mt-3">
    <c:if test="${user != null}">
    <form class="col-5 mx-auto" action="update_user" method="post" onsubmit="return validateFormInput()">
        <input type="hidden" name="userId" value="${user.userId}">
        </c:if>
        <c:if test="${user == null}">
        <form class="col-5 mx-auto" action="create_user" method="post" onsubmit="return validateFormInput()">
            </c:if>
            <div class="mb-3">
                <label for="email" class="float-start form-label">Email:</label>
                <input class="form-control" id="email" type="text" name="email" placeholder="example@mail.com" value="${user.email}">
            </div>
            <div class="mb-3">
                <label for="fullName" class="float-start form-label">Full Name:</label>
                <input class="form-control" id="fullName" type="text" name="fullname" placeholder="John Smith"
                       value="${user.fullName}">
            </div>
            <div class="mb-3">
                <label for="password" class="float-start form-label">Password:</label>
                <input class="form-control" id="password" type="password" name="password" placeholder="******"
                       value="${user.password}">
            </div>

            <button id="btn_save_id" type="submit" class="btn btn-dark text-white">Save</button>
            <button id="btn_cancel_id" type="button" class="btn btn-dark text-white" onclick="history.go(-1)">Cancel
            </button>
        </form>
</div>

<jsp:directive.include file="footer.jsp"/>
</body>

<script>
    function validateFormInput() {
        const fieldEmail = document.getElementById("email");
        const fieldFullName = document.getElementById("fullName");
        const fieldPassword = document.getElementById("password");

        if (fieldEmail.value.length === 0) {
            alert("Email is required!");
            fieldEmail.focus();
            return false;
        }

        if (fieldFullName.value.length === 0) {
            alert("Full Name is required!");
            fieldEmail.focus();
            return false;
        }

        if (fieldPassword.value.length === 0) {
            alert("Password is required!");
            fieldEmail.focus();
            return false;
        }
    }
</script>
</html>
