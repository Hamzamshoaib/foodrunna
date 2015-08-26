package com.foodrunna.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.foodrunna.DTO.UserDetails;

public class VerifyUser {
	
	//Get First Name of the user given a unique Email Identifier
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
		System.out.println("Rows Affected " + result);
		System.out.println(UniqueID);
	}

}
