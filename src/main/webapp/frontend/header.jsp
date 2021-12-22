<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
    <div>
        <img src="http://localhost:8081/BookStoreWebsite_war_exploded/images/BookstoreAdminLogo.png" alt="logo">
    </div>
    <div>&nbsp;</div>
    <div>
        <label><input type="text" name="keyword" size="50"></label>
        <label><input type="button" value="Search"></label>

        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="login">Login</a> |
        <a href="register">Register</a> |
        <a href="view_card">Card</a>
    </div>
    <div>&nbsp;</div>
    <div>
        <c:forEach var="category" items="${categoryList}" varStatus="status">
            <a href="view_category?id=${category.id}">
                <font size="+1"><b><c:out value="${category.name}"/></b></font>
            </a>
            <c:if test="${not status.last}">
                &nbsp; | &nbsp;
            </c:if>
        </c:forEach>
    </div>
</div>