<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>All users</title>
</head>
<body>
<h1>All users page</h1>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">E-mail</th>
        <th scope="col">Phone</th>
        <th scope="col">Login</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach var="user" items="${users}">
    <tr>
        <td>
            <p class="text-center">
                <c:out value="${user.id}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${user.name}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${user.surname}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${user.email}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${user.phone}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <c:out value="${user.login}"/>
            </p>
        </td>
        <td>
            <p class="text-center">
                <a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">Delete</a>
            </p>
        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
</table>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>
</body>
</html>
