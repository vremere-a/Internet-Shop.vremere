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
    <a href="${pageContext.request.contextPath}/products/add">Add item</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/users">Show all users</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/products">Show all item</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/admin/products">Show all item (Admin)</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/shopping-cart/products/add">Show user bucket</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/orders">Show user order</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/admin/orders">Show all orders (Admin)</a>
</p>
</body>
</html>
