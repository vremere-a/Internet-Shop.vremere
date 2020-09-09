<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>USER REGISTRATION</h1>

<h4 style="color: red">${message}</h4>
<form method="post" action="${pageContext.request.contextPath}/registration">
    <p><input type="text" name="name"> please, provide your name.</p>
    <p><input type="text" name="login"> please, provide your login.</p>
    <p><input type="password" name="pwd"> please, provide your password. </p>
    <p><input type="password" name="pwd-repeat"> please, repeat your password. </p>

    <button type="submit">Register</button>
</form>
</body>
</html>
