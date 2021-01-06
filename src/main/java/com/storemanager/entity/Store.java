package com.storemanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	private String storeId;
	private String storeName;
	private String contactNo;
	private String location;
	private String gstNumber;
	private String startDate;

	public Store() {
	}

	public Store(String storeName, String contactNo, String location, String gstNumber, String startDate) {
		this.storeName = storeName;
		this.contactNo = contactNo;
		this.location = location;
		this.gstNumber = gstNumber;
		this.startDate = startDate;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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
