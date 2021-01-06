package com.storemanager.controller;

import com.storemanager.dao.CustomerDao;
import com.storemanager.entity.CustomerDetails;
import com.storemanager.entity.Inventory;
import com.storemanager.entity.Store;
import com.storemanager.request.StoreRequest;
import com.storemanager.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerDao customerDao;
    //Save in db
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDetails customerDetails )
    {
        try {

            return ResponseEntity.ok(customerDao.save(customerDetails));
        }
        catch (Exception ex)
        {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getCustomerDetails() {

        try {

            List<CustomerDetails> customerList = customerDao.findAll();

        return ResponseEntity.ok(customerList);
        }
        catch (Exception ex)
        {
            return ResponseEntity.noContent().build();
        }

    }



}
