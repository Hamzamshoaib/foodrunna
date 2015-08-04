<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FoodRunna</title>
<link rel="stylesheet" type="text/css" href="resources/css/mystyle.css">
</head>
<body>
	<jsp:include page="/includeDirective/header.jsp" />
	<div class="try"></div>
	<form action="" method="POST">
		Email: <input type="text" name="email"><br>
		Password: <input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>
	<jsp:include page="/includeDirective/footer.jsp" />
</body>
</html>