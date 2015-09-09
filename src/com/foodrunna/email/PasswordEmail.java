package com.foodrunna.email;

public class PasswordEmail {
	
	public static void SendPasswordEmail (String to, String password, String firstName) {
		String subject = "Forgot Your Password - FoodRunna";
		String message = "Dear " + firstName + "\n\n"
         		+ "We have received a request to retrieve your password for FoodRunna\n\n"
         		+ "Your login password for FoodRunna is"
         		+ "\nPassword: " + password
         		+ "\n\n"
         		+ "Thanks\n"
         		+ "Team FoodRunna :)";
		
		Email email = new Email();
		email.sendEmail(to, subject, message);
	}

}
