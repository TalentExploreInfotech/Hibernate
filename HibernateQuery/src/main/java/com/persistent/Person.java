package com.persistent;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn ;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Person_Table")
@NamedQuery(name="selectQuery" , query="from Person p where p.name=?")
@NamedNativeQueries({@NamedNativeQuery(name="selectIdCombQuery" , query= "select * from Person_Table p where p.id=?" ,resultClass=Person.class),
	@NamedNativeQuery(name="selectNameCombQuery" , query= "select * from Person_Table p where p.name=?" ,resultClass=Person.class)})

@NamedNativeQuery(name="selectIdQuery" , query= "select * from Person_Table p where p.id=?" ,resultClass=Person.class)
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	    
}
