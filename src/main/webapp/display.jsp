<%@page import="java.util.List"%>
<%@page import="employee.dao.EmployeeDao"%>
<%@page import="employee.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	
	<h2>Welcome to home page</h2>
	
	<table border="5px">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>salary</th>
			<th>location</th>
			<th>gender</th>
			<th>delete</th>
			<th>edit</th>
			
		</tr>
		<c:forEach var="emp" items="${employees}">
		<tr>
			<td>${emp.id}  </td>
			<td>${emp.name}</td>
			<td>${emp.salary}</td>
			<td>${emp.location}</td>
			<td>${emp.gender}</td>
			<td><a href="delete?id=${emp.id}">delete</a></td>
			<td><a href="edit?id=${emp.id}">edit</a></td>
			</tr>
		</c:forEach>	
	
	</table>
	
	
	
	
	
	<h2> from jsp tags</h2>
	<table border = "2px">
	<tr>
	<th>name</th>
	</tr>
	<%
	EmployeeDao dao = new EmployeeDao();
	List<Employee> emps= dao.allemployees();
	for (Employee e :emps) {
	%>
	<tr>
	<td><%= e.getName()  %></td>
	</tr>
	
	<% } %>
	
	</table>
	

	
</body>
</html>