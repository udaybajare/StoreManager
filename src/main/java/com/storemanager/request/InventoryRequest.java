package com.storemanager.request;

import com.storemanager.entity.ImageModel;

import javax.annotation.sql.DataSourceDefinition;
import lombok.Data;

@Data
public class InventoryRequest {
    private String companyName;
    private String productName;
    private String productCode;
    private int quantity;
    private int unitPrice;
  //  private ImageModel image;
    private String availableStatus;
    private String inventoryEntryDate;
}
