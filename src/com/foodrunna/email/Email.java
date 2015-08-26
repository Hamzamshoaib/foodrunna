package com.foodrunna.email;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	
	String from;
    final String username = "hamzamshoaib";
    final String password = "12Tauqlia";
    String host;
    Properties props;
    Session session;
	
	public Email(){
		from = "hamzamshoaib@gmail.com";
		host = "smtp.gmail.com";
		
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
		});
	}
	
	public boolean sendVerifyEmail(String to, String IDToken, String firstName){

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));
	         // Set Subject: header field
	         message.setSubject("Please Verify Your Email Address For FoodRunna");
	         // Now set the actual message
	         message.setText("Dear " + firstName + "\n\n"
	         		+ "Welcome to FoodRunna! You are almost ready to get your favourite food delivered to you.\n\n"
	         		+ "To use your account, please verify your email by clicking this link "
	         		+ "\n\n\thttp://localhost:8080/foodrunna/verification?verification_token=" + IDToken
	         		+ "\n\n"
	         		+ "Thanks\n"
	         		+ "Team FoodRunna :)");

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully...");

	      } catch (MessagingException e) {
	    	  return false;
	      }
	 
		return true;
	}
}