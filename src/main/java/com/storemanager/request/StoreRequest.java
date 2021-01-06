package com.storemanager.request;

import lombok.Data;

@Data
public class StoreRequest {
    private String storeName;
    private String contactNo;
    private String location;
    private String gstNumber;
    private String startDate;

}
