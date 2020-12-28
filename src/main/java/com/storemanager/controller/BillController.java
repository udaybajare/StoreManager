package com.storemanager.controller;

import com.storemanager.request.BillRequest;
import com.storemanager.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.dao.BillDao;
import com.storemanager.entity.BillEntity;

@CrossOrigin
@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    BillDao billDao;

    @PostMapping
    public ResponseEntity<?> saveBill(@RequestBody BillRequest billRequest)
    {
        try
        {
            String bill = StoreUtil.generateId();

            BillEntity billEntity = new BillEntity();
            billEntity.setBillNo(bill);
            billEntity.setBillDate(billRequest.getBillDate());
            billEntity.setName(billRequest.getName());
            billEntity.setProductCode(billRequest.getProductCode());
            billEntity.setTotalAmount(billRequest.getTotalAmount());
            billEntity.setDiscount(billRequest.getDiscount());
            return ResponseEntity.ok(billDao.save(billEntity));
        }
        catch (Exception ex)
        {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
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


    @GetMapping("/{billNo}")
    public ResponseEntity<?> getBillByBillNo(@PathVariable(value = "billNo") String billNo)
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
