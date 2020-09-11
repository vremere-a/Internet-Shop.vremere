<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/orders/add">
    <h2>ITEMS IN YOUR BUCKET</h2>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Delete</td>

        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>
                    <c:out value="${product.id}"/>
                </td>
                <td>
                    <c:out value="${product.name}"/>
                </td>
                <td>
                    <c:out value="${product.price}"/>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/shopping-cart/products/delete?id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <button type="submit">checkout</button>
    <p>
        <a href="${pageContext.request.contextPath}/products">back to all items page</a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/">back to main page</a>
    </p>

</form>
</body>
</html>
