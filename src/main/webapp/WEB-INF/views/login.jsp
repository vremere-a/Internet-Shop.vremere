<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Title</title>
    <style>
        body {
            margin-left: 5%;
        }
    </style>
</head>
<body>
<h1>Login page</h1>
<h4 style="color: red"> ${errorMsg} </h4>

<form action="${pageContext.request.contextPath}/login" method="post">

    <div class="form-group">
        <label for="exampleInputEmail13">Login</label>
        <input type="text" class="form-check" id="exampleInputEmail13" name="login" aria-describedby="loginHelp">
        <small id="loginHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-check" name="pwd" id="exampleInputPassword1">
    </div>
    </p>
    <button type="submit" class="btn btn-primary">Login</button>
    <p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary" role="button" aria-pressed="true">back to
        main page</a>
</p>
</body>
</html>
