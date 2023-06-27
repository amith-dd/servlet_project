<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit page</title>
</head>
<body>
	<h1>Edit page</h1>
	
	<form:form action="update" modelAttribute="employee">
	id:<form:input path="id"  readonly="true" /><br>
	name:<form:input path="name"/><br>
	salary:<form:input path="salary"/><br>
	location:<form:input path="location"/><br>
	gender:<form:input path="gender"/><br>
	<input type="submit">
	</form:form>
	
</body>
</html>