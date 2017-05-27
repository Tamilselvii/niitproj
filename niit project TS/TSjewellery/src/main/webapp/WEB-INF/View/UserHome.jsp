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
<title>User Home</title>
</head>
<body>
<%@include file="Header.jsp" %>

<div class="container">
<c:forEach items="${prodlist}" var="prdt">
<div class = "row">
   <div class = "col-sm-6 col-md-3">
   	<a href = "ProductDesc/${prdt.prodid}" class = "thumbnail">
   	 <img src= "<c:url value="/resources/images/${prdt.prodid}.jpg"/>" alt = "Generic placeholder thumbnail"/>
   	</a>
   	  <div class = "caption">
         <h4>${prdt.prodname}</h4>
         <p> Rs.${prdt.price}</p>
      </div>
	</div>
</div>
</c:forEach>
</div>
<%@include file="footer.jsp" %>

</body>
</html>