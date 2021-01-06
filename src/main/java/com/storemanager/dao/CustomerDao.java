package com.storemanager.dao;

import com.storemanager.entity.CustomerDetails;
import com.storemanager.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerDao extends CrudRepository<CustomerDetails, Integer> {

    public List<CustomerDetails> findAll();

}
