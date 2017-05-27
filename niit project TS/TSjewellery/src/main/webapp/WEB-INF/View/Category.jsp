<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Bootstrap Case</title>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"

	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet"

	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<script

	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script

	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>product page</title>
</head>
<body>

<%@include file="Header.jsp" %>

<form action="CategoryAddition" method="get">
<table align="center">
	<tr><td colspan="2"><center>Category Details</center></td></tr>
	
<!-- 	<tr>
		<td>CategoryID</td>
		<td><input type="text" name="id"/></td>
	</tr> -->
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><textarea name="desc" cols="20" rows="5"></textarea></td>
	</tr>
	
	<tr>
		<td colspan="2"><center><input type="submit" value="SUBMIT"/></center></td>
	</tr>
	
</table>

</form>

<table cellspacing="2" cellpadding="2" align="center">

<tr bgcolor="pink">
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Description</td>
	
</tr>

<c:forEach items="${catlist}" var="cat">
<tr bgcolor="cyan">
	<td>${cat.id}</td>
	<td>${cat.name}</td>
	<td>${cat.desc}</td>
	<td>
		<a href="<c:url value="deleteCategory/${cat.id}"/>">Delete</a>
		<a href="<c:url value="${contextRoot }/updateCategory/${cat.id}"/>">Update</a>
	</td>
</tr>
</c:forEach>


</table>

<%@include file="footer.jsp" %>
</body>
</html>