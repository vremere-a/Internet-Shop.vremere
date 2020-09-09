<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>All items page</h2>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>

    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>
                <c:out value="${item.id}"/>
            </td>
            <td>
                <c:out value="${item.name}"/>
            </td>
            <td>
                <c:out value="${item.price}"/>
            </td>
<%--            <td>--%>
<%--                <a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">Delete</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>

</body>
</html>
