package com.storemanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillEntity {

	@Id
	String billNo;
	String billDate;
	String productCode;
	String totalAmount;
	String discount;
	String name;

	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
