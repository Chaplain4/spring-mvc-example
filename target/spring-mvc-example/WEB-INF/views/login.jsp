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
<form:form action="login" method="post">
    <b>login:</b>
    <form:input type="text" path="login"/><br>
    <b>password:</b>
    <form:input type="password" path="password"/><br>
    <input type="submit" value="Login">
</form:form>
</body>
</html>
