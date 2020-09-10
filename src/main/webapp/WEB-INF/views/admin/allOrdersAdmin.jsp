<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>ALL USERS ORDERS LIST (ADMIN)</h2>
<table border="1">
    <tr>
        <td>User ID</td>
        <td>Order ID</td>
        <td>Items</td>
        <td>Details</td>
        <td>Delete order</td>

    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${order.id}"/>
            </td>

            <td>
                <c:out value="${orders}" />
            </td><br>
            <td>
                <a href="${pageContext.request.contextPath}/orders/all/details?id=${order.id}">Details</a>
            </td>

            <td>
                <a href="${pageContext.request.contextPath}/order/delete?id=${order.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <p>
        <a href="${pageContext.request.contextPath}/products/all">back to all items page</a>
    </p>
</table>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>

</body>
</html>
