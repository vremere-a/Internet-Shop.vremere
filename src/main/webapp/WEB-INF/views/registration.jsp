<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Hello! please provide your user details</h1>
<form method="post" action="${pageContext.request.contextPath}/registration">
    Please provide your login: <input type="text" name="login">
    Please provide your password: <input type="text" name="password">

    <button type="submit">Register<button/>
</form>
</body>
</html>
