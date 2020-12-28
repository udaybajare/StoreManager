package com.storemanager.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.storemanager.entity.BillEntity;


public interface BillDao extends CrudRepository<BillEntity, String>
{

	public List<BillEntity> findAll();
	
	//public BillEntity save(BillEntity billEntity);

	public BillEntity findByBillNo(String billNo);

}
