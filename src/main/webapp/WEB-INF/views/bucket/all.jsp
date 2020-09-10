<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/checkout/order">
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
                <a href="${pageContext.request.contextPath}/items/delete/bucket?id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <p>
        <a href="${pageContext.request.contextPath}/items/all">back to all items page</a>
    </p>
</table>
<%--<p>--%>
<%--    <a href="${pageContext.request.contextPath}/checkout/order">checkout</a>--%>
<%--</p>--%>
    <button type="submit">checkout</button>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>

</form>
</body>
</html>
