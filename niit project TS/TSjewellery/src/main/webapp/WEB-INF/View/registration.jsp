<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>


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
</head>
<body>
<%@include file="Header.jsp" %>
	<!-- Text input-->
	<div class="form-group">
		<br>
		<form:form action="registration/user" commandName="user" method="POST">
			<form:input path="name" placeholder="Name" required="" />
			<br>
			<br>
			<span class="error"></span>

			<form:input path="email" placeholder="Email" required="" />
			<br>
			<br>
			<span class="error"></span>

			<form:input path="password" placeholder="Password" type="password"
				required="" />
			<br>
			<br>
			<span class="error"></span>

			<form:input path="contact" placeholder="Phone" required="" />
			<br>
			<br>
			<span class="error"></span>

			<form:select path="role">
				<form:option value="USER">User</form:option>
				<form:option value="SUPPLIER">Supplier</form:option>
			</form:select>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>