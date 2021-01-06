package com.storemanager.controller;

import com.storemanager.request.StoreRequest;
import com.storemanager.util.StoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.storemanager.dao.StoreDao;
import com.storemanager.entity.Store;



@RestController
@CrossOrigin
@RequestMapping("/api/store")
public class StoreController {

	@Autowired
	StoreDao storedao;

	//Save in db
	@PostMapping
	public ResponseEntity<?> saveStore(@RequestBody StoreRequest storeRequest )
	{
		try {
			String storeId = StoreUtil.generateStoreId();
			Store store = new Store(storeRequest.getStoreName(),storeRequest.getLocation(),storeRequest.getGstNumber(),storeRequest.getContactNo(),storeRequest.getStartDate());
			store.setStoreId(storeId);
			return ResponseEntity.ok(storedao.save(store));
		}
		catch (Exception ex)
		{
			return ResponseEntity.noContent().build();
		}
	}
	
	//All Store 
	@GetMapping
	public ResponseEntity<?> getStoreDetails()
	{
		try
		{
			return ResponseEntity.ok(storedao.findAll());
		}
		catch (Exception ex)
		{
			return ResponseEntity.noContent().build();
		}
	}
	


	//Search by storeName
	@GetMapping("/{storeName}")
	public ResponseEntity<?> getStoreByName(@PathVariable (value="storeName")String storeName)
	{
		try {
			return ResponseEntity.ok(storedao.findByStoreName(storeName));
		}
		catch (Exception ex)
		{
			return ResponseEntity.noContent().build();
		}
	}

	//Search by storeId
	@GetMapping("/{storeId}")
	public ResponseEntity<?> getStoreById(@PathVariable (value="storeId")String storeId)
	{
		try {
			return ResponseEntity.ok(storedao.findByStoreId(storeId));
		}
		catch (Exception ex)
		{
			return ResponseEntity.noContent().build();
		}
	}
}
