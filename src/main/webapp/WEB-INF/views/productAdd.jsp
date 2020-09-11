<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ITEM ADDING </title>
</head>
<body>
<h3>ITEM ADDING </h3>
<form method="post" action="${pageContext.request.contextPath}/products/add">
    <p>
        Item name <input type="text" name="name">
    </p>
    <p>
        Item price <input type="text" name="price">
    </p>
    <button type="submit">Add item</button>
    <p>
        <a href="${pageContext.request.contextPath}/products">show all items</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/">back to main page</a>
    </p>
</form>
</body>
</html>
