<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<h1>Join our Email List</h1>

	<form action="exampleURL" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="submit"></td>
			</tr>

		</table>

	</form>
	
	<table>
		<tr>
			<td align="left"> FirstName</td>
			<td align="left">LastName</td>
			<td align="left">Email</td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>