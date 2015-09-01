<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FoodRunna</title>
</head>
<body>
	<!--If statement below checks if a session exists -->
	<c:if test="${empty userEmail}">
		<c:redirect url="http://localhost:8080/foodrunna/login" />
	</c:if>
	<p>This is Home</p>
	<form action="home" method="POST">
		Restaurant: <input type="text" name="restaurant"><br>
		Delivery Address:<br>
		Street: <input type="text" name="street" value="${street}"><br>
		Suburb: <input type="text" name="suburb" value="${suburb}"><br>
		State: <input type="text" name="state" value="${state}"><br>
		Postcode: <input type="text" name="postcode" value="${postcode}"><br>
		Delivery Time: <input type="text" name="time"><br>
		Order:<br>
		<input type="text" name="order" placeholder="Item"> 
		<input type="text" name="quantity" placeholder="Qty">
		<input type="text" name="addinfo" placeholder="Additional Information">
		<br>
		<input type="submit" value="Order">
	</form>
</body>
</html>