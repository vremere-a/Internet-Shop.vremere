<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Registration</title>
    <style>
        body {
            margin-left: 5%;
        }
    </style>
</head>
<body>
<%@include file="/WEB-INF/views/index.jsp" %>
<h1>USER REGISTRATION</h1>

<h4 style="color: red">${message}</h4>

<form method="post" action="${pageContext.request.contextPath}/registration">
    <div class="form-group">
        <label for="exampleInputEmail10">First Name</label>
        <input type="text" class="form-check" id="exampleInputEmail10" name="name" aria-describedby="nameHelp">
        <small id="nameHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail11">Last Name</label>
        <input type="text" class="form-check" id="exampleInputEmail11" name="surname" aria-describedby="lastnameHelp">
        <small id="lastnameHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-check" id="exampleInputEmail1" name="email" aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail12">Phone</label>
        <input type="text" class="form-check" id="exampleInputEmail12" name="phone" aria-describedby="phoneHelp">
        <small id="phoneHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail13">Login</label>
        <input type="text" class="form-check" id="exampleInputEmail13" name="login" aria-describedby="loginHelp">
        <small id="loginHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-check" name="pwd" id="exampleInputPassword1">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword2">Password</label>
        <input type="password" class="form-check" name="pwd-repeat" id="exampleInputPassword2">
    </div>
    </p>
    <button type="submit" class="btn btn-primary">Register</button>
    <p>
</form>
</body>
</html>
