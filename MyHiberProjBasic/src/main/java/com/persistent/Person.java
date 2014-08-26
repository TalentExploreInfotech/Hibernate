package com.persistent;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person_Tab")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "city" , column=@Column(name="office_city")),@AttributeOverride(name = "state" , column=@Column(name="office_state")),@AttributeOverride(name = "country" , column=@Column(name="office_country"))})
	private Address officeAddress;
	@Embedded
	private Address address;
	public Person(String name, Address officeAddress, Address address) {
		super();
		this.name = name;
		this.officeAddress = officeAddress;
		this.address = address;
	}
public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person( String name) {
		super();
		this.name = name;
	}
	
	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
		this.officeAddress = address;
	}

	public int getId() {
		return id;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
