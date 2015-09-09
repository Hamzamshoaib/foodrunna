package com.foodrunna.email;

public class VerifyEmail {
	
	public static void sendVerifyEmail (String to, String idToken, String firstName) {
		
		String subject = "Please Verify Your Email Address For FoodRunna";
		String message = "Dear " + firstName + "\n\n"
         		+ "Welcome to FoodRunna! You are almost ready to get your favourite food delivered to you.\n\n"
         		+ "To use your account, please verify your email by clicking this link "
         		+ "\n\n\thttp://localhost:8080/foodrunna/verification?verification_token=" + idToken
         		+ "\n\n"
         		+ "Thanks\n"
         		+ "Team FoodRunna :)";
		
		Email email = new Email();
		email.sendEmail(to, subject, message);
	}

}
