<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
