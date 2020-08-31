package com.storemanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String companyName;
	String productName;
	String productCode;
	int quantity;
	int unitPrice;

	public Inventory() {
		super();
	}

	public Inventory(String companyName, String productName,
			String productCode, int quantity, int unitPrice) {
		super();
		this.companyName = companyName;
		this.productName = productName;
		this.productCode = productCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

}
