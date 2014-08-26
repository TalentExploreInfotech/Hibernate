package com.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	@Column(name="title")
	private String name;
	@Column(name="author")
	private String writer;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String writer) {
		super();
		this.id = id;
		this.name = name;
		this.writer = writer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", writer=" + writer + "]";
	}
	
	
	

}
