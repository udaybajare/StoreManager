package com.storemanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	int id;
	String storeName;
	String contactNo;
	String location;

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

}
