<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create New Category - Bookstore Administration</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>
        <c:if test="${category != null}">Edit Category</c:if>
        <c:if test="${category == null}">Create New Category</c:if>
    </h2>
</div>

<div align="center">
    <c:if test="${category != null}">
    <form action="update_category" method="post" onsubmit="return validateFormInput()">
        <input type="hidden" name="categoryId" value="${category.id}">
        </c:if>
        <c:if test="${category == null}">
        <form action="create_category" method="post" onsubmit="return validateFormInput()">
            </c:if>

            <table cellpadding="5">
                <tr>
                    <td>Name:</td>
                    <td><label for="name"><input id="name" type="text" name="name" size="20"
                                                 value="${category.name}"></label></td>
                </tr>

                <tr>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <label for="btn_save_id"><input id="btn_save_id" type="submit" value="Save" size="20"></label>
                        <label for="btn_cancel_id"><input id="btn_cancel_id" type="button" value="Cancel"
                                                          onclick="history.go(-1)"></label>
                    </td>
                </tr>
            </table>
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
