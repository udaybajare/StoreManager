package com.storemanager.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.storemanager.entity.Store;

public interface StoreDao extends CrudRepository<Store, String> {
	
	public List<Store> findAll();
	
	public Store save(Store store);

	public Store findByStoreName(String storeName);

	public Store findByStoreId(String storeId);
}
