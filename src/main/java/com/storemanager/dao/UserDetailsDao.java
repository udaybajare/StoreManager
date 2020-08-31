package com.storemanager.dao;

import org.springframework.data.repository.CrudRepository;


import com.storemanager.entity.UserDetails;



public interface UserDetailsDao extends CrudRepository<UserDetails, String> {
	
	public UserDetails save(UserDetails userDetails);

	public UserDetails findByUserName(String userName);
	
	public void delete(UserDetails user);
}
