package com.storemanager.request;
import lombok.Data;

@Data
public class InventoryUpdateRequest {
    private String companyName;
    private String productName;
    private int quantity;
    private int unitPrice;
    //  private ImageModel image;
    private String availableStatus;
    private String inventoryEntryDate;
}
