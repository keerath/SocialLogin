<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script src ="${pageContext.request.contextPath}/resources/js/passwordvalidation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<form action="reg/confirm" method="POST">
		<div class="form-group">
			<label><b>Email</b></label> <input type="email" class="form-control"
				id="registerEmal" name="email" placeholder="Enter email">
		</div>
		<div class="form-group">
			<label><b>Password</b></label> <input type="password" class="form-control"
				id="pass1" name="password" placeholder="Password">
		</div>
		<div class="form-group">
			<label><b>Confirm Password</b></label> <input type="password" class="form-control"
				id="pass2" placeholder="Confirm Password">
		</div>
		<div id="checkPasswordMatch">
		</div>
		<button id="registerButton" type="submit" class="btn btn-primary">Confirm</button>
		</form>
	</form>
</body>
</html>