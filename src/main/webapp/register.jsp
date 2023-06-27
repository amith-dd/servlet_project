<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>

<html>
<body>
<h2>Hello World!</h2>

<form:form action="save" modelAttribute="employee">
Employee ID:<form:input path="id"/><br>
Employee name:<form:input path="name"/><br>
Employee Salary:<form:input path="salary"/><br>
Employee location:<form:input path="location"/><br>
Employee Gender:<form:input path="gender"/><br>

				
<input type="submit">
</form:form>
</body>
</html>
