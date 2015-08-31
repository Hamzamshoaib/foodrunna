package com.foodrunna.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.foodrunna.DTO.UserDetails;

public class RegisterUser {
	public static void addToDatabase(UserDetails user) {
		//Saves user details in the database for registration
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

	}

}
