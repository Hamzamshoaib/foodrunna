package com.foodrunna.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodrunna.DTO.Status;
import com.foodrunna.DTO.UserDetails;
import com.foodrunna.bean.URL;
import com.foodrunna.email.Email;
import com.foodrunna.email.VerifyEmail;
import com.foodrunna.hibernate.GetUserDetails;
import com.foodrunna.hibernate.RegisterUser;
import com.foodrunna.inputcheck.EmailCheck;
import com.foodrunna.inputcheck.IsAlpha;
import com.foodrunna.inputcheck.MobileNumberCheck;
import com.foodrunna.inputcheck.PasswordCheck;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Acquiring all the parameters
		int i = 0;
		String userID = UUID.randomUUID().toString().replaceAll("-","");
		while (GetUserDetails.UserIdExists(userID)) {
			userID = UUID.randomUUID().toString().replaceAll("-","");
		}
		String userEmail = request.getParameter("email"); 
		String userPassword = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String firstName = request.getParameter("firstName"); 
		String lastName = request.getParameter("lastName"); 
		String mobile_Number = (request.getParameter("mobileNumber")).replaceAll("[^0-9]+", ""); //Sort out spaces in between the numbers
		Status status = Status.NORMAL;
		String mobile_Number_Verification = "unverified";
		String email_Verification = UUID.randomUUID().toString(); 
		Date dateCreated = new Date();
		
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		request.setAttribute("email", userEmail);
		request.setAttribute("mobile", mobile_Number);
		
		//Validating Input
		boolean invalidInput = false;
		ArrayList<String> message = new ArrayList<String>();
		if (firstName.isEmpty()) {
			request.removeAttribute("firstname");
			message.add("Please Enter Your First Name\n");
			invalidInput = true;
		}
		else if (!IsAlpha.isAlpha(firstName)) {
			request.removeAttribute("firstname");
			message.add("First Name can only contain letters\n");
			invalidInput = true;			
		}
		if (lastName.isEmpty()) {
			request.removeAttribute("lastname");
			message.add("Please Enter Your Last Name\n");
			invalidInput = true;
		}
		else if (!IsAlpha.isAlpha(lastName)) {
			request.removeAttribute("lastname");
			message.add("Last Name can only contain letters\n");
			invalidInput = true;
		}
		if (userPassword.isEmpty()) {
			message.add("Password Field/s Left Blank\n");
			invalidInput = true;
		}
		else if (!userPassword.equals(confirmPassword))  {
			message.add("Passwords Do Not Match\n");
			//message.add("Passwords must be 8 - 16 characters. Must contain Numbers, Uppercase and Lowercase and "
				//	+ "only the following characters (. [ ] _ ^ & # @ ? / ; :)\n");
			invalidInput = true;
		}
		else if (!PasswordCheck.passwordFormat(userPassword)) { //Matching Passwords
			message.add("Passwords must be 8 - 16 characters. Must Contain Numbers, Uppercase and Lowercase. Password May include" +
		" only the following characters (. [ ] _ ^ & # @ ? / ; :)");
			invalidInput = true;
		}
		if (userEmail.isEmpty()) {
			request.removeAttribute("email");
			message.add("Please Enter Your Email\n");
			invalidInput = true;
		}
		else if (!EmailCheck.emailFormat(userEmail)) {
			request.removeAttribute("email");
			message.add("Incorrect Email Format\n");
			invalidInput = true;
		}
		if (mobile_Number.isEmpty()) {
			request.removeAttribute("mobile");
			message.add("Please Enter Your Mobile Number\n");
			invalidInput = true;
		}
		else if (!MobileNumberCheck.MobileFormat(mobile_Number)) {
			request.removeAttribute("mobile");
			message.add("Please Provide a correct Mobile Number\n");
			invalidInput = true;
		}
		if (GetUserDetails.EmailExists(userEmail)) {
			request.removeAttribute("email");
			message.add("Email Address Already Exists");
			invalidInput = true;
		}
		
		if (invalidInput) {
			request.setAttribute("message", message);
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
		}
		else {
			UserDetails newUser = new UserDetails(userID,userEmail, userPassword, firstName, lastName, mobile_Number, status, 
					mobile_Number_Verification, email_Verification, dateCreated);
			RegisterUser.addToDatabase(newUser); //Add user to the database
			VerifyEmail.sendVerifyEmail(userEmail, email_Verification, firstName); //Send a verification email
			
			response.sendRedirect(URL.getUrl() + "login");
		}
	}

}
