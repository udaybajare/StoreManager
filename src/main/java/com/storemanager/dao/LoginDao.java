package com.storemanager.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.storemanager.entity.LoginInfo;


public interface LoginDao extends CrudRepository<LoginInfo, String> {
	
	public Optional<LoginInfo> findByUsername(String username);

}
