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


<h1>Pizzas List</h1>
<table border="2" width="70%" cellpadding="2">
  <tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
  <h2>${msg}<h2>
    <c:forEach var="pizza" items="${list}">
    <tr>
      <td>${pizza.id}</td>
      <td>${pizza.name}</td>
      <td>${pizza.size}</td>
      <td>${pizza.price}</td>
      <td><a href="editpizza/${pizza.id}">Edit</a></td>
      <td><a href="deletepizza/${pizza.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
<br/>
<a href="pizzaform">Add New Pizza</a>
</body>
</html>
