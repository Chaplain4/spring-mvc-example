<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 29.01.2024
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Edit Customer</h1>
<form:form method="POST" action="/spring_mvc_example_war/editC">
    <table border="0" cellpadding="5">
        <tr>
            <td>ID:</td>
            <td>${customer.id} <form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form></div>
</body>
</html>