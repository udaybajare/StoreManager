package com.storemanager.controller;

import java.util.List;
import com.storemanager.dao.AssignInventoryDao;
import com.storemanager.entity.AssignInventory;

import com.storemanager.request.AssignInventoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/assignInventory")
public class AssignInventoryController {

    @Autowired
    AssignInventoryDao assignInventoryDao;

    @PostMapping
    public ResponseEntity<?> saveAssignInventory(@RequestBody AssignInventoryRequest assignInventoryRequest) {
        try {
            AssignInventory assignInventory = new AssignInventory(assignInventoryRequest.getCompanyName(),assignInventoryRequest.getProductName(),assignInventoryRequest.getProductCode(),assignInventoryRequest.getQuantity(),assignInventoryRequest.getAvailableStatus(),assignInventoryRequest.getSelection(),assignInventoryRequest.getOrderedQuantity(),assignInventoryRequest.getStoreId(),assignInventoryRequest.getStoreName());
            return ResponseEntity.ok(assignInventoryDao.save(assignInventory));
        } catch (Exception ex) {
            System.out.println("Error "+ ex);
            ex.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @GetMapping
    public ResponseEntity<?> getAssignInventoryDetails() {

        List<AssignInventory> assignInventoryList =  assignInventoryDao.findAll();
        return ResponseEntity.ok(assignInventoryList);

    }


}

