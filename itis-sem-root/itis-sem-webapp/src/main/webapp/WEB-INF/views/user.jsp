<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<form:form method="POST" action="/user/add" modelAttribute="user">
    <form:hidden path="id"/>
    <table class="table table-hover">
        <td><label>Lastname</label></td>
        <td><form:input path="lastname"/></td>
        <td><FONT color="red"><springForm:errors path="lastname" cssClass="error" /></FONT></td>
        <tr>
            <td><label>Firstname</label></td>
            <td><form:input path="firstname"/></td>
            <td><FONT color="red"><springForm:errors path="firstname" cssClass="error" /></FONT></td>
        </tr>
        <tr>
            <td><label>Age</label></td>
            <td><form:input path="age"/></td>
            <td><FONT color="red"><springForm:errors path="age" cssClass="error" /></FONT></td>
        </tr>
    </table>
    <div class="btn-group">
        <button type="submit" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-pencil"></span> Save</button>
        <a href="user/all">
            <button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </a>
    </div>
</form:form>
</body>
</html>
