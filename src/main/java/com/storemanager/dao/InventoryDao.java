package com.storemanager.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.storemanager.entity.Inventory;


public interface InventoryDao extends CrudRepository<Inventory, String> {

	public List<Inventory> findAll();
	
	public Inventory save(Inventory inventory);

	public Inventory findByProductCode(String productCode);

	public List<Inventory> findByCompanyName(String companyName);
}
