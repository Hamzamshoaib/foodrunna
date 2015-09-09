<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.foodrunna.DTO.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FoodRunna - SignUp</title>
<link rel="stylesheet" type="text/css" href="resources/css/signup.css">
</head>
<body>
	<jsp:useBean id="url"  class="com.foodrunna.bean.URL" scope="page" />
	<!-- Links back to the login/home page -->
	<a href= "login">Home</a>
	<!-- For loop below prints out all the error messages -->
	<div id="dilogo"><img id="logo" src="images/logo.png" /></div>		
	<div class="container">
    <form  id = "signup" action="signup" method="POST">

        <div class="header">
        
            <h3>Register</h3>
            
            
        </div>
        <ul class="error"><c:forEach var="msg" items="${message}">
			<li><c:out value="${msg}" /></li>
		</c:forEach></ul>
        <div class="sep"></div><br>
        <div class="inputs">
        	<input type="text" name="firstName" placeholder="First Name" value="${firstname}">
        	<input type="text" name="lastName" placeholder="Last Name" value="${lastname}">
			<input type="text" name="email" placeholder="e-mail" value="${email}">
			<input type="password" name="password" placeholder="Password">
			<input type="password" name="confirmPassword" placeholder="Confirm Password">
			<input type="text" name="mobileNumber" placeholder="Mobile #" value="${mobile}">
            <input type="submit" id="register" value="Register">
        
        </div>
    </form>
</div>

</body>
</html>