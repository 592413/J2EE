<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> Thanks for joining our email list</h1>
	
	<%@ page import="demo.model.User" %>
	
	<% User user=(User) request.getAttribute("user"); %>
	
	<table>
		<tr>
			<td>FirstName</td>
			<td><%=user.getFirstName() %></td>	
		</tr>
		<tr>
			<td>LastName</td>
			<td><%=user.getLastName() %></td>	
		</tr>
		<tr>
			<td>Email</td>
			<td><%=user.getEmail() %></td>	
		</tr>
		
	</table>

</body>
</html>