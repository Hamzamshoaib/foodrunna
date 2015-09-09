package com.foodrunna.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory buildSessionFactory() {
		/*
		 * Hibernate Configuration Using Hibernate 4 Which uses the
		 * StandardServiceRegistryBuilder Sample Configuration shown below
		 * which is creating sessionFactory object from hibernate.cfg.xml
		 */
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}