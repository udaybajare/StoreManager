package com.storemanager.request;
import lombok.Data;

@Data
public class BillRequest {

    String billDate;
    String productCode;
    String totalAmount;
    String discount;
    String name;
}
