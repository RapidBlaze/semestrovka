<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Цена</th>
            <th>Id пользователя</th>
            <th>Продукт</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.price}</td>
                <td>${order.userId}</td>
                <td>${order.product}</td>
                <td><a href="/itis-sem-webapp/order/edit/${order.id}">
                    <button type="button" class="btn btn-default btn-xs"><span
                            class="glyphicon glyphicon-pencil"></span></button>
                </a></td>
                <td><a href="/itis-sem-webapp/order/delete/${order.id}">
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
