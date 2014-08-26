package com.persistent;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class FourWheeler extends Vehicle{
	private String fourType;
	@ManyToMany
	@JoinTable(name="user_LMV",joinColumns=@JoinColumn(name="LMV"),inverseJoinColumns=@JoinColumn(name="users"))
	private List<Person> users= new ArrayList<Person>();
	
	public FourWheeler(String make, String fourType) {
		super(make);
		this.fourType = fourType;
	}

	public FourWheeler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FourWheeler(String make) {
		super(make);
		// TODO Auto-generated constructor stub
	}

	public String getFourType() {
		return fourType;
	}

	public void setFourType(String fourType) {
		this.fourType = fourType;
	}

	@Override
	public String toString() {
		return "FourWheeler [fourType=" + fourType + "]";
	}

	public List<Person> getUsers() {
		return users;
	}

	public void setUsers(List<Person> users) {
		this.users = users;
	}
	
}
