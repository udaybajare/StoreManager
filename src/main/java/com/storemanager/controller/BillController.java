package com.storemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.dao.BillDao;
import com.storemanager.entity.BillEntity;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    BillDao billDao;

    @RequestMapping("/getAllBill")
    public ResponseEntity<?> getAllBill()
    {
        try {
            return ResponseEntity.ok(billDao.findAll());
        }
        catch (Exception ex)
        {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/saveBill")
    public ResponseEntity<?> saveBill(@RequestBody BillEntity billEntity)
    {
        try
        {
            return ResponseEntity.ok(billDao.save(billEntity));
        }
        catch (Exception ex)
        {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/getAllBill/{billNo}")
    public ResponseEntity<?> getBillByNo(@PathVariable(value = "billNo") String billNo)
    {
        try
        {
            return ResponseEntity.ok(billDao.findByBillNo(billNo));
        }
        catch (Exception ex)
        {
            return ResponseEntity.noContent().build();
        }

    }

}
