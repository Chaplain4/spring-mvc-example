<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hello Spring world!</h1>

<P>Server Time is ${serverTime}.</p><br>

<form action="user" method="post">
    <input type="text" name="name"><br> <input
        type="submit" value="Login">
</form>
<a href="/spring_mvc_example_war/login">Login?</a>
<a href="empform">Add Employee</a>
<a href="viewemp">View Employees</a>
</body>
</html>