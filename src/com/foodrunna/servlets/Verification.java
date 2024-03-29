package com.foodrunna.servlets;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrunna.bean.URL;
import com.foodrunna.hibernate.GetUserDetails;
import com.foodrunna.hibernate.VerifyUser;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uniqueID = request.getParameter("verification_token");
		if (uniqueID == null) {
			request.setAttribute("message", "Link Invalid or Expired");
			request.getRequestDispatcher("login").forward(request, response);
		}
		else if (Pattern.matches("[a-zA-Z0-9]{8}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{12}", uniqueID)) {
			System.out.println("matches");
			List<String> data = GetUserDetails.GetUserName(uniqueID);
			if (!data.isEmpty()) {
				System.out.println("FirstName is " + data.get(0));

				String firstName = data.get(0);
				String emailStatus = data.get(1);
				System.out.println("line 39");
				VerifyUser.ChangeToVerified(uniqueID);
				System.out.println("User " + firstName + " Changed to Verified");
				response.sendRedirect(URL.getUrl() + "home");
			}
			else {
				request.setAttribute("message", "Invalid ID or Account Already verified");
				request.getRequestDispatcher("login").forward(request, response);
			
			}

		}
		else {
			request.setAttribute("message", "Link Invalid or Expired");
			request.getRequestDispatcher("login").forward(request, response);
		}
		
	}

}
