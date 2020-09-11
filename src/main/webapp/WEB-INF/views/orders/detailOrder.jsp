<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>DETAILS ORDER</h2>
<table border="1">
    <tr>
        <td>Item ID</td>
        <td>Item name</td>
        <td>Item Price</td>
    </tr>
        <c:forEach var="product" items="${order.products}">
    <tr>
            <td>
                <c:out value="${product.id}" />
            </td>
            <td>
                <c:out value="${product.name}" />
            </td>
            <td>
                <c:out value="${product.price}" />
            </td>
        </c:forEach>
        </tr>
    <p>
        <a href="${pageContext.request.contextPath}/products/all">back to all items page</a>
    </p>
</table>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>

</body>
</html>
