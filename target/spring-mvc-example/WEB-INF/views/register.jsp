<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="register" method="post">
    <b>First name:</b>
    <form:input type="text" path="firstName" required="required"/><br>
    <b>Last name:</b>
    <form:input type="text" path="lastName" required="required"/><br>
    <b>login:</b>
    <form:input type="text" path="login" required="required"/><br>
    <b>password:</b>
    <form:input type="password" path="password" required="required"/><br>
    <b>email:</b>
    <form:input type="email" path="email" required="required"/><br>
    <input type="submit" value="Register">
</form:form>
</body>
</html>
