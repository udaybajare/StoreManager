package com.storemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.dao.InventoryDao;
import com.storemanager.entity.Inventory;


@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    InventoryDao inventorydao;

    @RequestMapping("/getInventoryDetails")
    public ResponseEntity<?> getInventoryDetails() {
        try {
            List<Inventory> inventoryList = inventorydao.findAll();
            return ResponseEntity.ok(inventoryList);
        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/saveInventoryDetails")
    public ResponseEntity<?> saveInventory(@RequestBody Inventory inventory) {
        try {
            return ResponseEntity.ok(inventorydao.save(inventory));
        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/getInventoryDetails/{productCode}")
    public ResponseEntity<?> updateInventory(@PathVariable(value = "productCode") String productCode, @RequestBody Inventory inventory) {
        try {
            Inventory inventoryByName = inventorydao.findByProductCode(productCode);
            inventoryByName.setCompanyName(inventory.getCompanyName());
            inventoryByName.setProductCode(inventory.getProductCode());
            inventoryByName.setProductName(inventory.getProductName());
            inventoryByName.setQuantity(inventory.getQuantity());
            inventoryByName.setUnitPrice(inventory.getUnitPrice());

            return ResponseEntity.ok(inventorydao.save(inventoryByName));

        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }
}
