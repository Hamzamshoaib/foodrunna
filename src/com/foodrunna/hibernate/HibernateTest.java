package com.foodrunna.hibernate;

import java.util.UUID;

import org.hibernate.Session;

import com.foodrunna.DTO.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {
//		UserDetails user = new UserDetails();
//		user.setFirstName("Hamza");
//		user.setLastName("Shoaib");
		for (int i = 0; i < 10; i++) {
			String email_Verification = UUID.randomUUID().toString().replaceAll("-",""); 
			System.out.println(email_Verification);
		}
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(user);
//		session.getTransaction().commit();
//		session.close();

	}

}


/*UserDetails user = new UserDetails();
user.setUserName("First User");
user.setRegDate(new Date());
 
 	UUID one = UUID.randomUUID(); //Unique ID Generator
	System.out.println(one);
 
Address addr = new Address();
addr.setStreet("Street Name");
addr.setSuburb("Glenwood");
addr.setState("NSW");
addr.setPostcode("2768");

user.setAddress(addr);
Session session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
session.save(user);
session.getTransaction().commit();
session.close();

user = null;

session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
user = (UserDetails) session.get(UserDetails.class, 1);
System.out.println("User Name Retrived is " + user.getAddress().getSuburb());
session.getTransaction().commit();
session.close();*/