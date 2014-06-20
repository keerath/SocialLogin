<html>
<head>
<title>Social LogIn</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/mystyles.css"
	rel="stylesheet">
</head>
<body>
<form id="reg" action="signin/reg" method="GET">
		<button id="register" type="submit" class="btn btn-default">Register</button>
		<input type="hidden" value="register">
	</form>
	<h3 id="wrongCredentrials">${msg}</h3>
	<form action="signin/google" method="POST">
		<button id="google" type="submit" class="btn btn-danger btn-sm">SignIn
			with Google+</button>
		<input type="hidden" name="scope"
			value="email https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www.googleapis.com/auth/drive https://www.googleapis.com/auth/latitude.all.best" />
		<input type="hidden" name="request_visible_actions"
			value="http://schemas.google.com/AddActivity http://schemas.google.com/BuyActivity http://schemas.google.com/CheckInActivity http://schemas.google.com/CommentActivity http://schemas.google.com/CreateActivity http://schemas.google.com/DiscoverActivity http://schemas.google.com/ListenActivity http://schemas.google.com/ReserveActivity http://schemas.google.com/ReviewActivity http://schemas.google.com/WantActivity" />
		<input type="hidden" name="access_type" value="offline" />
	</form>
	<form id="login" role="form" action="signin/login" method="POST">
		<div class="form-group">
			<label><b>Email</b></label> <input name="email" type="email" class="form-control"
				id="exampleInputEmail1" placeholder="Enter email">
		</div>
		<div class="form-group">
			<label><b>Password</b></label> <input name="password" type="password" class="form-control"
				id="exampleInputPassword1" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary">LogIn</button>
		</form>
		
</body>
</html>
