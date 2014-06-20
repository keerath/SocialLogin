<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/app/styles/bootstrap.min.css" />
<link rel="stylesheet"
	href="resources/app/styles/jquery-ui-1.10.0.custom.css" />
<link rel="stylesheet" href="resources/app/styles/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav pull-right">
					<li><a href="signout">Sign Out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<h1>Welcome! ${msg}</h1>
</body>
</html>