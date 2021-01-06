package com.storemanager.request;

import lombok.Data;

@Data
public class AssignInventoryRequest {

    private String storeId;
    private String storeName;
    private String companyName;
    private String productName;
    private String productCode;
    private int quantity;

    private String availableStatus;
    //private ImageModel image;
    private String selection;
    private int orderedQuantity;



}
