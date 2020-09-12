<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>USER REGISTRATION</h1>

<h4 style="color: red">${message}</h4>

<form method="post" action="${pageContext.request.contextPath}/registration">
    <p>
        <input type="text" placeholder="Name" name="name"> enter your name
    </p>
    <p>
        <input type="text" placeholder="Surname" name="surname"> enter your surname
    </p>
    <p>
        <input type="text" placeholder="E-mail" name="email"> enter your e-mail.
    </p>
    <p>
        <input type="text" placeholder="Phone" name="phone"> enter your phone number.
    </p>
    <p>
        <input type="text" placeholder="Login" name="login"> enter your login.
    </p>
    <p>
        <input type="password" placeholder="Password" name="pwd"> enter your password.
    </p>
    <p>
        <input type="password" placeholder="Password" name="pwd-repeat"> please, repeat your password.
    </p>
    <button type="submit">Register</button>
    <p>
        <a href="${pageContext.request.contextPath}/">back to main page</a>
    </p>
</form>
</body>
</html>
