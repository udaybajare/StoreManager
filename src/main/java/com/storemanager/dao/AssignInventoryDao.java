package com.storemanager.dao;

import com.storemanager.entity.AssignInventory;
import com.storemanager.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssignInventoryDao extends CrudRepository<AssignInventory, Integer> {

    public AssignInventory save(AssignInventory assignInventory);
    public List<AssignInventory> findAll();

}
