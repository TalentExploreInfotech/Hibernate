package com.persistent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory  sessionFactory =  new Configuration().configure().buildSessionFactory();
    	Session session= sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(new Book("My Biography", "Nishant Niranjan"));
    	session.save(new Person("Nishant Niranjan",new Address("LKO","UP","India"),new Address("Lucknow","UP","India")));
    	session.getTransaction().commit();
    	session.close();
        System.out.println( "Hello World!" );
    }
}
