<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<%@include file="/WEB-INF/views/index.jsp" %>
<h2>ALL USERS ORDERS LIST (ADMIN)</h2>
<table class="table table-danger">
    <thead>
    <tr>
        <th scope="col">User ID</th>
        <th scope="col">Order ID</th>
        <th scope="col">Items</th>
        <th scope="col">Details</th>
        <th scope="col">Delete order</th>
    </tr>
    </thead>
    <tbody>
    <tr>
    <c:forEach var="order" items="${orders}">
    <tr>
        <td>
            <p class="text-center">
                <c:out value="${order.userId}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${order.orderId}"/>
            </p>
        </td>

        <br>
        <td>
            <p class="text-center">
                <a href="${pageContext.request.contextPath}/orders/details?id=${order.orderId}">Details</a>
            </p>
        </td>

        <td>
            <p class="text-center">
                <a href="${pageContext.request.contextPath}/orders/delete?id=${order.orderId}">Delete</a>
            </p>
        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
    <p>
        <a href="${pageContext.request.contextPath}/products" class="btn btn-info" role="button" aria-pressed="true">back to all items page</a>
    </p>
</table>
</body>
</html>
