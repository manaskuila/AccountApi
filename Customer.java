package com.account.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	private String custName;
	private String customerstatus;
	//private String custDob;
	private String  age;
	
	public String getCustomerstatus() {
		return customerstatus;
	}
	public void setCustomerstatus(String customerstatus) {
		this.customerstatus = customerstatus;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String id, String custName, String age,String customerstatus) {
		super();
		this.id = id;
		this.custName = custName;
		this.age = age;
		this.customerstatus = customerstatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

}
