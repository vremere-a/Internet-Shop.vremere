<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h2>All items page</h2>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Price,$</th>
        <th scope="col">Buy</th>
    </tr>
    </thead>
    <tbody>
    </tr>
    <c:forEach var="product" items="${products}">
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
            <td>
                <p class="text-center">
                    <a href="${pageContext.request.contextPath}/shopping-cart/product/add?id=${product.id}">Buy</a>
                </p>
            </td>
        </tr>
    </c:forEach>
    </tr>
    </tbody>
</table>
<p>
    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary" role="button" aria-pressed="true">back to main page</a>
</p>

</body>
</html>
