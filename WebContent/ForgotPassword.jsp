<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FoodRunna - Forgot Password</title>
<link rel="stylesheet" type="text/css" href="resources/css/forgotpassword.css" media="screen" />
</head>
<body>
	
	<div id="dilogo"><img id="logo" src="images/logo.png" /></div>	
	<!-- Including the header file -->
	<div class="container">
		<div id="signup">
    		<form  action="forgotpassword" method="POST">
			<br><br>
        	<div class="header">
            	<h3>Forgot Password!</h3>
	        </div>
        
        	<div class="sep"></div><br>
        	<p class="error">${message}</p>
        	<div class="inputs">
        
            	<input type="email" name = "email" placeholder="e-mail" autofocus />
            	<input type="submit" id="login" value="Retrieve Password">
        
        	</div>
           </form>
        </div>
     </div>

</body>
</html>