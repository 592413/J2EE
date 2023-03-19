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
	
	
	<% 
	String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String email=request.getParameter("email");
	
	%>
	
	<table>
		<tr>
			<td>FirstName</td>
			<td><%=firstName %></td>	
		</tr>
		<tr>
			<td>LastName</td>
			<td><%=lastName %></td>	
		</tr>
		<tr>
			<td>Email</td>
			<td><%=email %></td>	
		</tr>
		
	</table>

</body>
</html>