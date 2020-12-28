package com.storemanager.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class Inventory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	private String companyName;
	private String productName;
	private String productCode;
	private int quantity;
	private int unitPrice;
	//private ImageModel image;
	private String availableStatus;
	private String inventoryEntryDate;


	@Override
	public String toString() {
		return super.toString();
	}

	public Inventory() {
		super();
	}


	public Inventory(String companyName, String productName, String productCode, int quantity, int unitPrice,  String availableStatus, String inventoryEntryDate) {
		this.companyName = companyName;
		this.productName = productName;
		this.productCode = productCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		//this.image = image;
		this.availableStatus = availableStatus;
		this.inventoryEntryDate = inventoryEntryDate;
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



	public String getInventoryEntryDate() { return inventoryEntryDate; }

	public void setInventoryEntryDate(String inventoryEntryDate) { this.inventoryEntryDate = inventoryEntryDate; }

	public String getAvailableStatus() { return availableStatus; }

	public void setAvailableStatus(String availableStatus) { this.availableStatus = availableStatus; }

//	public ImageModel getImage() {
//		return image;
//	}
//
//	public void setImage(ImageModel image) {
//		this.image = image;
//	}
}
