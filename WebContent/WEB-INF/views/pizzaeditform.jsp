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


<h1>Edit Pizza</h1>
<form:form method="POST" action="/spring_mvc_example_war/editsavepizza">
  <table >
    <tr>
      <td></td>
      <td><form:hidden  path="id" /></td>
    </tr>
    <tr>
      <td>Name : </td>
      <td><form:input path="name"  /></td>
    </tr>
    <tr>
      <td>Size :</td>
      <td><form:input path="size" /></td>
    </tr>
    <tr>
      <td>Price :</td>
      <td><form:input path="price" /></td>
    </tr>

    <tr>
      <td> </td>
      <td><input type="submit" value="Edit Save" /></td>
    </tr>
  </table>
</form:form>
</body>
</html>
