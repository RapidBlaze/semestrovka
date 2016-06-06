<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Возраст</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.lastname}</td>
                <td>${user.firstname}</td>
                <td>${user.age}</td>
                <td><a href="/itis-sem-webapp/user/edit/${user.id}">
                    <button type="button" class="btn btn-default btn-xs"><span
                            class="glyphicon glyphicon-pencil"></span></button>
                </a></td>
                <td><a href="/itis-sem-webapp/user/delete/${user.id}">
                    <button type="button" class="btn btn-default btn-xs"><span
                            class="glyphicon glyphicon-remove"></span></button>
                </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
