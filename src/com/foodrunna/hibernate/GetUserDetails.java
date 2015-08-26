package com.foodrunna.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.foodrunna.DTO.UserDetails;

public class GetUserDetails {
	
	//Get First Name of the user given a unique Email Identifier and checks for verfication
	public static List GetUserName (String UniqueID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<String> details = new ArrayList();
		try {
			session.beginTransaction();
			System.out.println("get username");
			Criteria crit = session.createCriteria(UserDetails.class);
			crit.add(Restrictions.eq("email_Verification", UniqueID));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("firstName"));
			proList.add(Projections.property("email_Verification"));
			crit.setProjection(proList);
			List<Object[]> result = crit.list();
			if (!result.isEmpty()) {
				for (Object[] r: result) {
					details.add((String)r[0]);
					details.add((String)r[1]);				
				}
			}
			/*String hql = "SELECT u.firstName, u.email_Verfication FROM UserDetails u WHERE email_Verification = :uniqueid";
			Query query = session.createQuery(hql);
			query.setString("uniqueid", UniqueID);
			result = query.list();*/
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//System.out.println("result = " + details.get(0) + "\nEmail Status = " + details.get(1));
		return details;	
	}
	
	public static boolean EmailExists (String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<String> result = new ArrayList();
		session.beginTransaction();
		String hql = "SELECT u.userEmail FROM UserDetails u WHERE userEmail = :email";
		Query query = session.createQuery(hql);
		query.setString("email", email);
		result = query.list();
		session.getTransaction().commit();
		session.close();
		
		if (!result.isEmpty()) {
			return true;
		}
		
		return false;
		
	}
	public static boolean UserIdExists (String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<String> result = new ArrayList();
		session.beginTransaction();
		String hql = "SELECT u.userEmail FROM UserDetails u WHERE userEmail = :email";
		Query query = session.createQuery(hql);
		query.setString("email", id);
		result = query.list();
		session.getTransaction().commit();
		session.close();
		
		if (!result.isEmpty()) {
			return true;
		}
		
		return false;
		
	}
	
	
	public static String ValidateLogin (UserDetails loginInfo) {
		String exists;
		String value = new String();
		Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crit = session.createCriteria(UserDetails.class);
			crit.add(Restrictions.eq("userEmail", loginInfo.getUserEmail()));
			crit.add(Restrictions.eq("userPassword", loginInfo.getUserPassword()));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("email_Verification"));
			crit.setProjection(proList);
			List<String> result = crit.list();
			if (result.isEmpty() || result.size() > 1) {
				exists = "invalid";
			}
			else {
				value = result.get(0);
				if (value.equals("verified")) {
					exists = "verified";
				}
				else {
					exists = "unverified";
				}
			}
			
			session.getTransaction().commit();
			session.close();
		
		return exists;
	}
}
