<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04.02.2024
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add New Pizza</title>
</head>
<body>
<h1>Add New Pizza</h1>
<form:form method="post" action="savePizza">
    <table >
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
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
