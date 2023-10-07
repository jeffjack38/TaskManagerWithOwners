<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type="text" name = "listName"><br />
Task Date: <input type="text" name = "month" placeholder="mm" size="4">
<input type="text" name = "day" placeholder="dd" size="4">
<input type="text" name = "year" placeholder="yyyy" size="4">
Owner Name: <input type="text" name = "ownerName"><br />

Available Tasks:<br />
<select name = "allITasksToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allTasks}" var="currenttask">
<option value = "${currenttask.id}"> ${currenttask.title} | ${currenttask.description} | ${currenttask.status}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create list and Add Tasks">

</form>
<a href="index.html">Go add new tasks instead</a>
</body>
</html>