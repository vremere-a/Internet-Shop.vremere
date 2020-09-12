<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h2>YOUR ORDERS LIST</h2>
<table class="table table-dark">
    <thead>
    <tr>
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
                <c:out value="${order.id}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${orders}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <a href="${pageContext.request.contextPath}/orders/details?id=${order.id}">Details</a>
            </p>
        </td>
        <td>
            <p class="text-center">
                <a href="${pageContext.request.contextPath}/orders/delete?id=${order.id}">Delete</a>
            </p>
        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
</table>
<p>
    <a href="${pageContext.request.contextPath}/products">back to all items page</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>
</body>
</html>
