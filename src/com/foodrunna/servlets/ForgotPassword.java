package com.foodrunna.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrunna.bean.URL;
import com.foodrunna.email.PasswordEmail;
import com.foodrunna.hibernate.GetUserDetails;
import com.foodrunna.inputcheck.EmailCheck;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if (email.isEmpty()) {
			request.setAttribute("message", "Please Enter Your Email\n");
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
			
		}
		else if (!EmailCheck.emailFormat(email)) {
			request.setAttribute("message", "Incorrect Email Format\n");
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
		}
		else {
			List<String> results = GetUserDetails.GetPassword(email);
			System.out.println("size = " + results.size());

			if (results.size() == 2) {
				String firstName = results.get(0);
				String password = results.get(1);
				PasswordEmail.SendPasswordEmail(email, password, firstName);
				response.sendRedirect(URL.getUrl() + "login");
			}
			else {
				request.setAttribute("message", "Email Account Does Not Exist\n");
				request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
			}
		}
	}

}
