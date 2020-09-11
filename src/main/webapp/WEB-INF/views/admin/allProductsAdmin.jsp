<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>ALL ITEMS (ADMIN)</h2>
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
                <a href="${pageContext.request.contextPath}/products/delete?id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="${pageContext.request.contextPath}/products">back to all items page</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>

</body>
</html>