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
<h2>DETAILS ORDER</h2>
<p>
    <a href="${pageContext.request.contextPath}/products" class="btn btn-info" role="button" aria-pressed="true">back to
        all items page</a>
</p>
<table class="table table-info">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Price,$</th>
    </tr>
    </thead>
    <tbody>
    </tr>
    <c:forEach var="product" items="${order.products}">
    <tr>
        <td>
            <p class="text-center">
                <c:out value="${product.id}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${product.name}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${product.price}"/>
            </p>
        </td>
        </c:forEach>
    </tr>
    </tbody>
</table>
<p>
    <a href="${pageContext.request.contextPath}/orders" class="btn btn-info" role="button" aria-pressed="true">back to
        orders</a>
</p>

</body>
</html>
