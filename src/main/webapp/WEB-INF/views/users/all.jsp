<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1>All users page</h1>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Surname</td>
        <td>E-mail</td>
        <td>Phone</td>
        <td>Login</td>
        <td>Delete</td>

    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>
            <c:out value="${user.id}"/>
        </td>
        <td>
            <c:out value="${user.name}"/>
        </td>
        <td>
            <c:out value="${user.surname}"/>
        </td>
        <td>
            <c:out value="${user.email}"/>
        </td>
        <td>
            <c:out value="${user.phone}"/>
        </td>
        <td>
            <c:out value="${user.login}"/>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">Delete</a>
        </td>
    </tr>
    </c:forEach>
</table>
<p>
    <a href="${pageContext.request.contextPath}/">back to main page</a>
</p>
</body>
</html>
