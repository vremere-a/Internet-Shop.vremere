<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>ITEM ADDING </title>
    <style>
        body {
            margin-left: 5%;
        }
    </style>
</head>
<body>
<h3>ITEM ADDING </h3>
<p>
    <a href="${pageContext.request.contextPath}/products" class="btn btn-info" role="button" aria-pressed="true">show
        all items page</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/products/add">
    <div class="form-group">
        <label for="exampleInputEmail10">Product Name</label>
        <input type="text" class="form-check" id="exampleInputEmail10" name="name">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail11">Product price</label>
        <input type="text" class="form-check" id="exampleInputEmail11" name="price">
    </div>
    </p>
    <button type="submit" class="btn btn-primary">Add product</button>
    <p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary" role="button" aria-pressed="true">back to
        main page</a>
</p>
</form>
</body>
</html>
