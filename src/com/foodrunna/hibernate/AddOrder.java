package com.foodrunna.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.foodrunna.DTO.ItemsInOrder;
import com.foodrunna.DTO.UserDetails;

public class AddOrder {
	public static void addOrderToDatabase(ItemsInOrder items) {
		//Saves user details in the database for registration
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(items);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}


}
