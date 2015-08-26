<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.foodrunna.DTO.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FoodRunna - SignUp</title>
</head>
<body>
	<a href="Login.jsp">Home</a>
	<h1>Registration Form</h1>
	<c:forEach var="msg" items="${message}">
		<c:out value="${msg}" /> <br>
	</c:forEach>
	<p> Passwords must be 8 - 16 characters. Must contain Numbers, Uppercase, Lowercase and
		only the following characters (. [ ] _ ^ & # @ ? / ; :)</p>
	<c:set var="message" value="" scope="request" />
	<form action="signup" method="POST">
		First Name: <input type="text" name="firstName"><br>
		Last Name: <input type="text" name="lastName"><br>
		Email: <input type="text" name="email"><br>
		Password: <input type="password" name="password"><br>
		Confirm Password: <input type="password" name="confirmPassword"><br>
		Mobile #: <input type="text" name="mobileNumber"><br>
		<input type="submit" value="Register">
	</form>
</body>
</html>