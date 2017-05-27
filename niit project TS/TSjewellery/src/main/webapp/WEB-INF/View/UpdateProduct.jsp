<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>

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

	<%@include file="Header.jsp"%>





	<div class="container">

		<div class="row">

			<div class="col-sm-4">

				<div class="updateproduct-form">

					<!--sign up form-->

					<h2>Product Form</h2>

					<br>

					<form:form

						action="${pageContext.request.contextPath}/UpdateProduct"

						modelAttribute="product">

						<table>

							<tr>

								<td colspan="2">Product Details</td>

							</tr>

							<tr>

								<td>Product ID</td>

								<td><form:input path="prodid" /></td>

							</tr>

							<tr>

								<td>Product Name</td>

								<td><form:input path="prodname" /></td>

							</tr>

							<tr>

								<td>Category</td>

								<td><form:input path="catid" /></td>

							</tr>

							<tr>

								<td>Supplier</td>

								<td><form:input path="suppid" /></td>

							</tr>

							<tr>

								<td>Price</td>

								<td><form:input path="price" /></td>

							</tr>

							<tr>

								<td>Stock</td>

								<td><form:input path="stock" /></td>

							</tr>

							<tr>

								<td>Product Desc</td>

								<td><form:textarea path="desc" /></td>

							</tr>

							<tr>

								<td colspan="2"><center>

										<input type="submit" value="Update Product" />

									</center></td>

							</tr>



						</table>

					</form:form>







				</div>

			</div>

		</div>

	</div>


<%@include file="footer.jsp"%>
</body>

</html>
