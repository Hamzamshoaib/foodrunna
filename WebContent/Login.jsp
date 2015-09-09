<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.foodrunna.DTO.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FoodRunna - Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/login.css" media="screen" />
</head>
<body>
	<!-- If statement below checks to see if a session exists -->
	<c:if test="${not empty userEmail}">
		<jsp:useBean id="url"  class="com.foodrunna.bean.URL" scope="page" />
		<c:redirect url= "home"/>
	</c:if>
	<div id="dilogo"><img id="logo" src="images/logo.png" /></div>	
	<!-- Including the header file -->
	<%--<jsp:include page="/includeDirective/loginHeader.jsp" />--%>
	<div class="container">
	<div id="signup">
    <form  action="login" method="POST">

        <div class="header">
        
            <h3>Login</h3>
            
            
        </div>
        
        <div class="sep"></div><br>
		<p class="error">${message}</p>
        <div class="inputs">
        
            <input type="email" name = "email" placeholder="e-mail" autofocus />
        
            <input type="password" name = "password" placeholder="Password" />
            <a href="forgotpassword">Forgot Your Password?</a>
            
            <input type="submit" id="login" value="Login">
        
        </div>
    </form>
    <form action="signup" method ="GET"> <div class="inputs"><input type="submit" id ="register" value="Register"></div>
   </form>
   </div>
</div>
	
	

	
</body>
</html>