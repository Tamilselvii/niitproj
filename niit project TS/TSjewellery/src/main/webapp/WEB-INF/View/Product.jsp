<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Product Page</title>

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

</head>

<body>

	<%@include file="Header.jsp" %>





	<div class="container">

		<div class="row">

			<div class="col-sm-4">

				<div class="product-form">

					<!--sign up form-->

					<h2>Product Form</h2>

					<br>

					<form:form action="addProduct" modelAttribute="product"

					enctype="multipart/form-data"	>

						<table align="center">

							<tr>

								<td colspan="2"><center>Product Details</center></td>

							</tr>

							<%-- <tr>

								<td>Product ID</td>

								<td><form:input path="productid" /></td>

							</tr> --%>

							<tr>

								<td>Product Name</td>

								<td><form:input path="productname" /></td>

							</tr>

							<tr>

								<td>Category</td>

								<td><form:select path="categoryid">

										<form:option value="0" label="------Select----" />

										<form:options items="${catlist}" />

									</form:select></td>

							</tr>

							  <tr>

							 	<td>Supplier</td>

								<td><form:input path="supplierid" /></td>

							</tr> 

							<tr>

								<td>Price</td>

								<td><form:input path="productcost" /></td>

							</tr>

							<tr>

								<td>Stock</td>

								<td><form:input path="stock" /></td>

							</tr>

							<tr>

								<td>Product Desc</td>

								<td><form:textarea path="productdesc" /></td>

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



					<table align="center" border="5">

						<tr >

							<td>Product ID</td>

							<td>Product Name</td>

							<td>Category ID</td>

							<td>Supplier ID</td>

							<td>Price</td>

							<td>Stock</td>

							<td>Operation</td>

						</tr>



						<c:forEach items="${proddet}" var="prod">

							<tr>

								<td>${prod.productid}</td>

								<td>${prod.productname}</td>

								<td>${prod.categoryid}</td>

								<td>${prod.supplierid}</td>

								<td>${prod.productcost}</td>

								<td>${prod.stock}</td>

								<td><a href="<c:url value="deleteProduct/${prod.productid}" />">Delete||</a>

									<a href="<c:url value="updateProduct/${prod.productid}" />">Update</a>

								</td>

							</tr>

						</c:forEach>



					</table>







				</div>

			</div>

		</div>

	</div>
	<%@include file="footer.jsp" %>

	</body>

</html>