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

	<c:if test="${empty userEmail}">
		<c:redirect url="http://localhost:8080/foodrunna/login" />
	</c:if>	
	<p>This is Home</p>
</body>
</html>