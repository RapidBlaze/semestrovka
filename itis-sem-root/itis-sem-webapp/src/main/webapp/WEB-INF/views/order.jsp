<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<%@include file="header.jsp" %>
<c:if test="${order != null}">
    <form:form method="POST" action="/itis-sem-webapp/order/add" modelAttribute="order">
        <table class="table table-hover">
            <tr hidden>
                <td><form:hidden path="id"/></td>
            </tr>
            <tr>
                <td><label>Пользователи: </label></td>
                <td>
                    <form:select path="userId">
                        <form:options items="${users}" itemLabel="lastname" itemValue="id"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><label>Продукт</label></td>
                <td><form:input path="product"/></td>
                <td><span style="color: red"><springForm:errors path="product" cssClass="error"/></span></td>
            </tr>
            <tr>
                <td><label>Цена</label></td>
                <td><form:input path="price"/></td>
                <td><span style="color: red"><springForm:errors path="price" cssClass="error"/></span></td>
            </tr>
            <tr>
                <div class="btn-group">
                    <td>
                        <button type="submit" class="btn btn-default btn-sm"><span
                                class="glyphicon glyphicon-pencil"></span> Save
                        </button>
                    </td>
                    <td><a href="/itis-sem-webapp/order/all">
                        <button type="button" class="btn btn-default btn-sm"><span
                                class="glyphicon glyphicon-remove"></span>Cancel
                        </button>
                    </a></td>
                </div>
            </tr>
        </table>
    </form:form>
</c:if>
</body>
</html>
