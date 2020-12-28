package com.storemanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String storeName;
	private String contactNo;
	private String location;
	private String gstNumber;
	private String startDate;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getGstNumber() {return gstNumber;	}

	public void setGstNumber(String gstNumber) { this.gstNumber = gstNumber;}

	public String getStartDate() {return startDate;}

	public void setStartDate(String startDate) { this.startDate = startDate; }
}
