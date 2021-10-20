package com.reimbursement.util;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		
		
		try {

			Properties props = new Properties();
			FileReader connectionProperties;
			connectionProperties = new FileReader("src/main/resources/connection.properties");
			props.load(connectionProperties);
			
			if(sessionFactory == null) {
				sessionFactory = new Configuration().configure()
						.setProperty("hibernate.connection.url", props.getProperty("db_url"))
						.buildSessionFactory();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(HibernateException e) {
			e.printStackTrace();
		}

		
		
		return sessionFactory.getCurrentSession();
	}
}
