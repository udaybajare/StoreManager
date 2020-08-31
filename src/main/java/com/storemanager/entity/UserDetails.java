package com.storemanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	String userName;

	int id;
	String fullName;
	String Contact;
	String Role;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
}
