<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>MAIN MENU</h1>
<p>
    <a href="${pageContext.request.contextPath}/inject-data">Inject test data into the DB</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/registration">REGISTRATION</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/product/add">Add item</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/users/all">Show all users</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/products/all">Show all item</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/products/all/admin">Show all item (Admin)</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/shopping-cart/products/add">Show user bucket</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/orders/all">Show user order</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/admin/orders/all">Show all orders (Admin)</a>
</p>
</body>
</html>
