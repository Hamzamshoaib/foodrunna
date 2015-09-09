package com.foodrunna.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.foodrunna.DTO.ItemDetails;
import com.foodrunna.DTO.ItemsInOrder;
import com.foodrunna.DTO.OrderDetails;

public class AddOrder {
	public static void addOrderToDatabase(OrderDetails orderdetail, List<ItemDetails> items, int[] quantity, String[] addInfo) {
		//Saves user details in the database for registration
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			for (int i=0; i < items.size(); i++) {
				System.out.println("in add");
				ItemsInOrder itemInOrder = new ItemsInOrder(orderdetail, items.get(i), quantity[i], addInfo[i]);
				session.save(itemInOrder);
				if (i % 20 == 0) {
					session.flush();
					session.clear();
				}
				
			}
			//session.save(items);
			//session.save(items);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}


}
