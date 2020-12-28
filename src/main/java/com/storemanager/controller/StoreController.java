package com.storemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.dao.StoreDao;
import com.storemanager.entity.Store;

@RestController
@RequestMapping("/api/store")
public class StoreController {

	@Autowired
	StoreDao storedao;

	//Save in db
	@PostMapping
	public ResponseEntity<?> saveStore(@RequestBody Store store )
	{
		try {
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
}
