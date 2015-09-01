package com.foodrunna.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class VerifyUser {
	
	//Verifies user email address
	public static void ChangeToVerified (String UniqueID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int result = 0;
		try {
			session.beginTransaction();
			String hql = "UPDATE UserDetails u SET u.email_Verification = :verify WHERE u.email_Verification = :uniqueid";
			Query query = session.createQuery(hql);
			query.setString("verify", "verified");
			query.setString("uniqueid", UniqueID);
			result = query.executeUpdate();
			
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
