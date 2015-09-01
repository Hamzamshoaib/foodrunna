package com.foodrunna.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodrunna.DTO.Address;
import com.foodrunna.DTO.ItemDetails;
import com.foodrunna.DTO.ItemsInOrder;
import com.foodrunna.DTO.OrderDetails;
import com.foodrunna.DTO.UserDetails;
import com.foodrunna.hibernate.AddOrder;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restaurant = request.getParameter("restaurant");
		String street = request.getParameter("street");
		String suburb = request.getParameter("suburb");
		String state = request.getParameter("state");
		String postcode = request.getParameter("postcode");
		String order = request.getParameter("order");
		String time = request.getParameter("time");
		int qty = Integer.parseInt(request.getParameter("quantity"));
		String addInfo = request.getParameter("addinfo");
		UserDetails user = new UserDetails();
		user.setUserID((String)request.getSession().getAttribute("userID"));
		
		Address address = new Address(street,suburb,state,postcode);
		ItemDetails items = new ItemDetails(restaurant,order);
		OrderDetails orderDetail = new OrderDetails(user, restaurant, time, address, 0, 0);
		ItemsInOrder itemInOrder = new ItemsInOrder(orderDetail, items, qty, addInfo);
		
		AddOrder.addOrderToDatabase(itemInOrder);
		response.sendRedirect("http://localhost:8080/foodrunna/home");
	
	}

}
