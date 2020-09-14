<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Title</title>
    <style>
        body {
            margin-left: 2%;
        }
    </style>
</head>
<body>
<ul class="nav nav-pills nav-justified">
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown"
           href="#" role="button" aria-haspopup="true"
           aria-expanded="false">Add</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/registration">USER</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/products/add">PRODUCT</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown"
           href="#" role="button" aria-haspopup="true"
           aria-expanded="false">SHOW</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/users">USER</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/products">PRODUCT</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/shopping-cart/products/add">CART</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/orders">ORDER</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown"
           href="#" role="button" aria-haspopup="true"
           aria-expanded="false">SHOW(ADMIN)</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/products">USER</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/orders">PRODUCT</a>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.contextPath}/inject-data">Inject</a>
    </li>
</ul>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

</body>
</html>
