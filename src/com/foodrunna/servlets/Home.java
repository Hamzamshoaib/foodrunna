package com.foodrunna.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.foodrunna.DTO.Address;
import com.foodrunna.DTO.ItemDetails;
import com.foodrunna.DTO.ItemsInOrder;
import com.foodrunna.DTO.OrderDetails;
import com.foodrunna.DTO.UserDetails;
import com.foodrunna.bean.URL;
import com.foodrunna.hibernate.AddOrder;
import com.foodrunna.inputcheck.AlphaNumeric;
import com.foodrunna.inputcheck.IsAlpha;
import com.foodrunna.inputcheck.IsNumeric;

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
		//Getting all the user input
		String restaurant = request.getParameter("restaurant");
		String street = request.getParameter("street");
		String suburb = request.getParameter("suburb");
		String state = request.getParameter("state");
		String postcode = request.getParameter("postcode");
		String hour = request.getParameter("hr");
		String minute = request.getParameter("minute");
		String[] order = request.getParameterValues("order");
		String[] qty = request.getParameterValues("quantity");//.replaceAll("[^0-9]+", "");
		String[] addInfo = request.getParameterValues("addinfo");
		UserDetails user = new UserDetails();
		user.setUserID((String)request.getSession().getAttribute("userID"));
		
		List<ItemDetails> items = new ArrayList();
 		for (int j = 0; j < order.length; j++) {
 			ItemDetails item = new ItemDetails();
			if (!order[j].isEmpty() && !qty[j].isEmpty())
				item.setRestaurantName(restaurant);
				item.setItemName(order[j]);
				items.add(item);
		}
 		
		
		boolean invalidInput = false;
		ArrayList<String> message = new ArrayList<String>();
		if (restaurant.isEmpty()) {
			message.add("Enter A Restaurant Name");
			invalidInput = true;
		}
		if (street.isEmpty()) {
			message.add("Please Enter Street Address");
			invalidInput = true;
		}
		else if (!AlphaNumeric.isAddress(street)) {
			message.add("Enter A Valid Street Address");
			invalidInput = true;
		}
		if (suburb.isEmpty()) {
			message.add("Please Enter a Suburb");
			invalidInput = true;
		}
		else if (!IsAlpha.isAlpha(suburb)) {
			message.add("Enter A Valid Suburb");
			invalidInput = true;
		}
		if (postcode.isEmpty()) {
			message.add("Please Enter a Postcode");
			invalidInput = true;
		}
		else if (!IsNumeric.isValidPostcode(postcode)) {
			message.add("Please Enter a 4 digit Postcode");
			invalidInput = true;
		}
		int[] quantity = new int[qty.length];
		if (qty.length != 0) {
			boolean invalidQty = false;
			 for (int i = 0; i < qty.length; i++) {
				 if (IsNumeric.isNumeric(qty[i]) && !qty[i].isEmpty()) {
					quantity[i] = Integer.parseInt(qty[i]);
				 }
				 else {
					 invalidQty = true;
				 }
			 }
			 if (invalidQty) {
				 message.add("Quantity Can Only Contain Numbers");
				 invalidInput = true;
			 }
		}
		String time = new String();
		if (hour.equals("ASAP")) {
			time = "ASAP";
		}
		else {
			time = hour + " : " + minute;
		}
		
		if (invalidInput) {
			request.setAttribute("message", message);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else {
		
		Address address = new Address(street,suburb,state,postcode);
		//ItemDetails items = new ItemDetails(restaurant,order);
		OrderDetails orderDetail = new OrderDetails(user, restaurant, time, address);
		//ItemsInOrder itemInOrder = new ItemsInOrder(orderDetail, items, quantity, addInfo);
		
		AddOrder.addOrderToDatabase(orderDetail, items, quantity, addInfo);
		HttpSession session = request.getSession();
		message.add("Your Order Has Been Submitted!");
		session.setAttribute("message", message);
		//response.sendRedirect("ConfirmOrder.jsp");
		request.getRequestDispatcher("ConfirmOrder.jsp").forward(request, response);
		}
	
	}

}
