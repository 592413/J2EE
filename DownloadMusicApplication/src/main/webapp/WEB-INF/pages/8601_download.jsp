<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.download.model.User" %>
<% String productCode=(String) session.getAttribute("productCode");

	User user=(User) session.getAttribute("user");


%>
<div style="float:right"> Hi <%= user.getFirstName()%></div>
<h1>86 band - True Life Songs & Pictures - <%= productCode%></h1>
</body>
</html>