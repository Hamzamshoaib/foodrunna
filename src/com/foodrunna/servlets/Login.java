package com.foodrunna.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodrunna.DTO.UserDetails;
import com.foodrunna.hibernate.GetUserDetails;
import com.foodrunna.inputcheck.EmailCheck;
import com.foodrunna.inputcheck.PasswordCheck;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fine = (String)request.getAttribute("firstTime");
		if (fine == null){
			System.out.println("Sup para = " + fine);
			
		}
		UserDetails user = new UserDetails();
		String email = request.getParameter("email");
		String pw = request.getParameter("password");
		String message;
		//Checking for Correct Input
		if (!EmailCheck.emailFormat(email) || !PasswordCheck.passwordFormat(pw)) {
			message = "Invalid Email or Password!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			//Storing details in UserDetails object
			user.setUserEmail(email);
			user.setUserPassword(pw);
			List<String> validLogin = GetUserDetails.ValidateLogin(user);
			if (validLogin.get(0).equals("verified")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userEmail", email);
				session.setAttribute("userID", validLogin.get(1));
				//HttpSession session = request.getSession();
				//UserDetails user = (UserDetails)session.getAttribute("users");
				System.out.println("valid login");
				System.out.println(validLogin.get(1));
				response.sendRedirect("http://localhost:8080/foodrunna/home");
			}
			else if (validLogin.get(0).equals("unverified")) {
				message = "Please Verify Your Account to Login!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else {
				message = "Invalid Email or Password!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		
	}

}
