package com.storemanager.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int    id;
    String customerName;
    int    customerContactNo;
    String billNo;
    String amount;

}
