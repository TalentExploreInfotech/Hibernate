package com.persistent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="company_tab")
public class Company {
	@Id
	private String regPlate;
	private  String name;
	private String area;
	@OneToOne(mappedBy="serviceCompany")
	private Person person; 
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(String regPlate, String name, String area) {
		super();
		this.regPlate = regPlate;
		this.name = name;
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", area=" + area + "]";
	}
	public String getRegPlate() {
		return regPlate;
	}
	public void setRegPlate(String regPlate) {
		this.regPlate = regPlate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	 
}
