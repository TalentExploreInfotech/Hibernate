package com.persistent;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bike extends Vehicle{
	private String type;
	@ManyToOne
	@JoinColumn(name="userId")
	private Person user;
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bike(String make, String type) {
		super(make);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Bike [type=" + type + "]";
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}
	
	
	
}
