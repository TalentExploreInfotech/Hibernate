package com.persistent;

import java.util.List;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
       Criteria criteria = session.createCriteria(Person.class);
       criteria.add(Restrictions.eq("id", 1));
       List<Person> persons =criteria.list();
       System.out.println("person::"+persons);
       criteria.setProjection(Projections.property("name"));
       System.out.println(criteria.list());
       System.out.println("persons::"+persons);
       Person person =new Person();
       person.setName("nishant1");
       Example example = Example.create(person);
       Criteria criteria1 = session.createCriteria(Person.class).add(example);
       System.out.println(criteria1.list());
       
    }
}
