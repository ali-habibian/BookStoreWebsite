<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Create New Category - Bookstore Administration</title>
</head>
<body class="container text-center">
<jsp:directive.include file="header.jsp"/>

<div class="row text-center">
    <h2 class="mt-4">
        <c:if test="${category != null}">Edit Category</c:if>
        <c:if test="${category == null}">Create New Category</c:if>
    </h2>
</div>

<div class="row pt-3 pb-3">
    <c:if test="${category != null}">
    <form class="col-5 mx-auto" action="update_category" method="post" onsubmit="return validateFormInput()">
        <input type="hidden" name="categoryId" value="${category.id}">
        </c:if>
        <c:if test="${category == null}">
        <form class="col-5 mx-auto" action="create_category" method="post" onsubmit="return validateFormInput()">
            </c:if>

            <div class="mb-3">
                <label for="name">Name:</label>
                <input id="name" type="text" name="name" placeholder="Category Name" value="${category.name}">
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
        const fieldName = document.getElementById("name");

        if (fieldName.value.length === 0) {
            alert("Full Name is required!");
            fieldName.focus();
            return false;
        }
    }
</script>

</html>
