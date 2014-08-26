package com.persistent;

import java.util.ArrayList;
import java.util.List;

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
    	List<Address> homeAddresses = new ArrayList<Address>();
    	homeAddresses.add(new Address("pune","MH","India"));
    	homeAddresses.add(new Address("LKO","UP","India"));
    	Person p=new Person("Nishant Niranjan",new Address("LKO","UP","India"),homeAddresses);
    	Person p1=new Person("N N",new Address("Pune","MH","India"),homeAddresses);
    	FourWheeler fourWheeler1 = new FourWheeler("ford","figo");
    	FourWheeler fourWheeler2 = new FourWheeler("Hundai","i20");
    	FourWheeler fourWheeler3 = new FourWheeler("Maruti","Swift");
    	Company c1= new Company("C001","Barclays", "Pune");
    	p.setServiceCompany(c1);
    	Bike bike = new Bike("Hero Honda","CBZ");
    	Bike bike1 = new Bike("Honda","Activa");
    	//p.getVehicles().add(vehicle);
    	//Vehicle v1= new Vehicle("Hero Honda");
    	p.getFourWheelers().add(fourWheeler1);
    	p.getFourWheelers().add(fourWheeler2);
    	p1.getFourWheelers().add(fourWheeler2);
    	p1.getFourWheelers().add(fourWheeler3);
    	fourWheeler1.getUsers().add(p);
    	fourWheeler2.getUsers().add(p);
    	//OSCacheProvider 
    	fourWheeler2.getUsers().add(p1);
    	fourWheeler3.getUsers().add(p1);
    	p.getBikes().add(bike);
    	p.getBikes().add(bike1);
    	bike.setUser(p);
    	bike1.setUser(p);
    	c1.setPerson(p);
    	session.save(c1);
    	session.persist(p);session.persist(p1);
    	
    	session.getTransaction().commit();
    	session.close();
    	Session session1 = sessionFactory.openSession();
    	session1.beginTransaction();
    	Company c2 =(Company)session1.get(Company.class, "C001");
    	 bike =(Bike)session1.get(Bike.class, 1);
    	 System.out.println("Vehicle::"+bike);
        System.out.println( "Hello World!" +c2+ "person::"+c2.getPerson());
    }
}
