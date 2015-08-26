<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.foodrunna.DTO.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FoodRunna - Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/mystyle.css">
</head>
<body>

	<c:if test="${not empty userEmail}">
		<c:redirect url="http://localhost:8080/foodrunna/Home.jsp" />
	</c:if>	
	<jsp:include page="/includeDirective/loginHeader.jsp" />
	<div class="try"></div>
	${message}
	<form action="login" method="POST">
		Email: <input type="text" name="email"><br>
		Password: <input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>
	<form action="signup" method ="GET"> <input type="submit" value="Register"> </form>

	
</body>
</html>