package com.storemanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssignInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String companyName;
    private String productName;
    private String productCode;
    private int quantity;

    private String availableStatus;
    //private ImageModel image;
    private String selection;
    private int orderedQuantity;
    private String storeId;
    private String storeName;


    public AssignInventory() {
    }

    public AssignInventory(String companyName, String productName, String productCode, int quantity, String availableStatus, String selection, int orderedQuantity, String storeId, String storeName) {
        this.companyName = companyName;
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.availableStatus = availableStatus;
        this.selection = selection;
        this.orderedQuantity = orderedQuantity;
        this.storeId = storeId;
        this.storeName = storeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
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
}
