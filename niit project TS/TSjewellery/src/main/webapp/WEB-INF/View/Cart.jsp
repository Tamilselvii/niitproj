<%@ page language="java" contentType="text/html"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Header.jsp" %>

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
<title>Cart page</title>
</head>
<body>

<div class="container">

		<div class="row">

			<div class="col-sm-4">

				<div class="cart-form">

					<!--sign up form-->

					<h2>cart Form</h2>

					<br>

					<form:form action="addtoCart" modelAttribute="cart"

						enctype="multipart/form-data">

						<table align="center">

							<tr>

								<td colspan="2"><center>Cart Details</center></td>

							</tr>

							<%-- <tr>

								<td>Cart ID</td>

								<td><form:input path="cartid" /></td>

							</tr> --%>
							<tr>

								<td>Product ID</td>

								<td><form:input path="productid" /></td>

							</tr>
							

							<tr>

								<td>Cart Name</td>

								<td><form:input path="username" /></td>

							</tr>

							

							  <tr>

							 	<td>Status</td>

								<td><form:input path="status" /></td>

							</tr> 

							<tr>

								<td>quality</td>

								<td><form:input path="quality" /></td>

							</tr>

							<tr>

								<td>sub Total</td>

								<td><form:input path="subtotal" /></td>

							</tr>

							

							<tr>

								<td>Product Image</td>

								<td><form:input type="file" path="image" /></td>

							</tr> 

							<tr>

								<td colspan="2"><center>

										<input type="submit" />

									</center></td>

							</tr>



						</table>

					</form:form>
<tr bgcolor='pink'>
	<td>Product ID</td>
	<td>Quantity</td>
	<td>SubTotal</td>
	<td>Image</td>
	<td>Operation</td>
</tr>
<c:forEach items="${cartitems}" var="cartitem">
	<form action="<c:url value="updateCartItem/${cartitem.id}"/>" method="get">
	<tr>	
		<td>${cartitem.prodid}</td>
		<td><input type="text" name="qty" value="${cartitem.quantity}"/></td>
		<td>${cartitem.subtotal}</td>
		<td><img src="<c:url value='resources/image/${cartitem.prodid}.jpg'/>" width="100" height="100" /></td>
		<td>
			<a href="<c:url value="deleteCartItem/${cartitem.id}"/>">Delete</a>
			<input type="submit" value="UPDATE" class="btn btn-xs btn-success btn-block"/>
		</td>
	</tr>
	</form>
</c:forEach>
	<tr>
		<td colspan="2"><a href="<c:url value='/UserHome/'/>">Continue Shopping</a>
		
	</tr>
</table>

</div>
<%@include file="footer.jsp" %>


</body>
</html>