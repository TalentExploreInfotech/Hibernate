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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@ElementCollection
	@JoinTable(name="Home_Address",joinColumns={@JoinColumn(name="userId")})
	private List<Address> addresses ;
	
	@OneToOne
	@JoinColumn(name="company")
	private Company serviceCompany;
	
	@OneToMany(mappedBy="user",cascade =CascadeType.PERSIST)
	private List<Bike>bikes = new ArrayList<Bike>();
	
	@ManyToMany(mappedBy="users",cascade=CascadeType.PERSIST)
	private List<FourWheeler> fourWheelers = new ArrayList<FourWheeler>();
	
	public Person(String name, Address officeAddress, List<Address> addresses) {
		super();
		this.name = name;
		this.officeAddress = officeAddress;
		this.addresses = addresses;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Company getServiceCompany() {
		return serviceCompany;
	}
	public void setServiceCompany(Company serviceCompany) {
		this.serviceCompany = serviceCompany;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", officeAddress="
				+ officeAddress + ", addresses=" + addresses
				+ ", serviceCompany=" + serviceCompany + "]";
	}
	public List<Bike> getBikes() {
		return bikes;
	}
	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}
	public List<FourWheeler> getFourWheelers() {
		return fourWheelers;
	}
	public void setFourWheelers(List<FourWheeler> fourWheelers) {
		this.fourWheelers = fourWheelers;
	}
	
    
}
