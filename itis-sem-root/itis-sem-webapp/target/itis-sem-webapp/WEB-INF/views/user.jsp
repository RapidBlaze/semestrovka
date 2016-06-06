<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%@include file="header.jsp" %>
<c:if test="${user != null}">
<form:form method="POST" action="/itis-sem-webapp/user/add" modelAttribute="user">
    <table class="table table-hover">
        <tr hidden>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><label>Имя</label></td>
            <td><form:input path="lastname"/></td>
            <td><span style="color: red"><springForm:errors path="lastname" cssClass="error"/></span></td>
        </tr>
        <tr>
            <td><label>Фамилия</label></td>
            <td><form:input path="firstname"/></td>
            <td><span style="color: red"><springForm:errors path="firstname" cssClass="error"/></span></td>
        </tr>
        <tr>
            <td><label>Возраст</label></td>
            <td><form:input path="age"/></td>
            <td><span style="color: red"><springForm:errors path="age" cssClass="error"/></span></td>
        </tr>
        <tr>
            <div class="btn-group">
                <td><button type="submit" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-pencil"></span> Save</button></td>
                <td><a href="/itis-sem-webapp/user/all"><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span>Cancel</button></a></td>
            </div>
        </tr>
    </table>
</form:form>
</c:if>
</body>
</html>
