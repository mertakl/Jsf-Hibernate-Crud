package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory = buildSessionFactoryObj();

	// Create The SessionFactory Object From Standard (Hibernate.cfg.xml)
	// Configuration File

	@SuppressWarnings("deprecation")

	public static SessionFactory buildSessionFactoryObj() {

		try {

			factory = new Configuration().configure().buildSessionFactory();

		} catch (ExceptionInInitializerError exceptionObj) {

			exceptionObj.printStackTrace();

		}

		return factory;

	}

	public static SessionFactory getSessionFactory() {

		return factory;

	}

}
