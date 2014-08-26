package com.persistent;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session  session =  sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Person("Nishant Niranjan"));
        session.save(new Person("Nishant"));
        session.save(new Person("Niranjan"));
        session.save(new Person("Nishant Niranjan1"));
        session.save(new Person("Nishant1"));
        session.save(new Person("Niranjan1"));
        session.save(new Person("Nishant Niranjan2"));
        session.save(new Person("Nishant2"));
        session.save(new Person("Niranjan2"));
        session.save(new Person("Nishant Niranjan3"));
        session.save(new Person("Nishant3"));
        session.save(new Person("Niranjan3"));
        session.save(new Person("Nishant Niranjan4"));
        session.save(new Person("Nishant4"));
        session.save(new Person("Niranjan4"));
        session.getTransaction().commit();
        session.close();
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Person");
        query.setFirstResult(2);
        query.setMaxResults(2);
        List<Query> persons = query.list();
        System.out.println("persons1::"+persons);
        persons = query.list();
        System.out.println("persons2::"+persons);
        Person p3 =(Person) session.get(Person.class,1);
        Person p4 =(Person) session.get(Person.class,2);
        
        System.out.println("person33::"+p3);
        System.out.println("person44::"+p4);
        Query query1 = session.createQuery("from Person p  where p.id=1");
        persons = query1.list();
        System.out.println("Persons::"+persons);
        Query query2 = session.createQuery("from Person p  where p.id=?");
        query2.setInteger(0, 2);
        persons = query2.list();
        System.out.println("Persons::"+persons);
        Query query3 = session.createQuery("from Person p  where p.id=:id");
        query3.setInteger("id", 3);
        persons = query3.list();
        System.out.println("Persons::"+persons);
        Query query4 = session.getNamedQuery("selectQuery");
        query4.setString(0, "nishant");
        List<Person> person5 = query4.list();
        System.out.println("Persons5::"+person5);
        Query query5 = session.getNamedQuery ("selectIdQuery");
        query5.setInteger(0, 3);
        List<Person> person6 = query5.list();
        System.out.println("Persons6::"+person6);
        Query query6 = session.getNamedQuery ("selectIdCombQuery");
        query6.setInteger(0, 3);
        List<Person> person7 = query6.list();
        System.out.println("Persons6::"+person7);  
        
       // Criteria criteria = session.createCriteria(Person.class);
        
    }
}
