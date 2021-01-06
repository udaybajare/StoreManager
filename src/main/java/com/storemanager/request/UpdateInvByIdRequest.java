package com.storemanager.request;

import lombok.Data;

@Data
public class UpdateInvByIdRequest {
    private int quantity;
    private String availableStatus;
}
