<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FoodRunna - Order Information</title>
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
	<form action="logout" method="POST"><input type="submit" value="Logout"></form>
	<!--If statement below checks if a session exists -->
	<c:if test="${empty userEmail}">
		<c:redirect url= "login" />
	</c:if>
	<p id="test"> </p>
	<div id="dilogo"><img id="logo" src="images/logo.png" /></div>	
	<div class="container">
    <form  id = "signup" action="home" method="POST">

        <div class="header">
        
            <h3>Order</h3>
            
       
        </div>
        <ul class="error"><c:forEach var="msg" items="${message}">
			<li><c:out value="${msg}" /></li>
		</c:forEach></ul>
		<c:remove var="message"/>
        <div class="sep"></div><br>
        <div class="inputs">
        	<input type="text" name="restaurant" placeholder="Restaurant" maxlength= "50">
        	<p>Delivery Address:</p>
        	<input type="text" name="street" placeholder="Street" value="${street}" maxlength="100">
			<input type="text" name="suburb" placeholder="Suburb" value="${suburb}" maxlength="50">
			<label for="state"></label>
			<select id="login"><option value="NSW">NSW</option></select><br>
			<input type="text" name="postcode" placeholder="Postcode" value="${postcode}" maxlength="4">
			<p>Delivery Time: </p>
			<script type="text/javascript" src="resources/js/home.js">
				//This script configures dropdown menu for minutes	
			</script>

			<c:set var="now" value="<%=new java.util.Date()%>" />
			<fmt:formatDate type="time" value="${now}" pattern="H" var="hour"/>
			<fmt:formatDate type="time" value="${now}" pattern="m" var="minute"/>
			<select id="hr" name="hr" class="register" onchange="configureDropDownLists(this,document.getElementById('ddl2'))">
				<option value="ASAP">ASAP</option>
				<c:choose>
					<c:when test="${hour > 14 || hour < 11}">
						<c:forEach var="i" begin="11" end="14">
							<option value="${i}">${i}</option>
						</c:forEach>
					</c:when> 
			
					<c:when test="${hour >= 11}">
						<c:forEach var="i" begin="${hour}" end="14">
							<option value="${i}">${i}</option>
						</c:forEach>	
					</c:when>
				</c:choose>
			</select>
			<b id="colon">:</b>
			<select id="ddl2" name="minute" class="register">
			</select><br><br>
			<p>Order:</p>
				<div id="list_item">
					<input type="text" name="order" placeholder="Item" maxlength="254">
					<input type="text" name="quantity" placeholder="Qty" value="1" maxlength="2"> 
					<input type="text" name="addinfo" placeholder="Additional Information" maxlength="3000">
				</div>
				<input type = "button" id="add_item" onClick="addItem()" value="+" /> 
				<input type="submit" id="login" value="Order!">
        
        </div>
    </form>
</div>
</body>
</html>
