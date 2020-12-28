package com.storemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.storemanager.dao.UserDetailsDao;
import com.storemanager.entity.UserDetails;

@RestController
@RequestMapping("/api/user")
public class UserDetailsController {

	@Autowired
	UserDetailsDao userDetailsDao;

	@PostMapping
	public UserDetails saveUser(@RequestBody UserDetails userDetails )
	{
			return userDetailsDao.save(userDetails);
	}
	
	@GetMapping("/{userName}")
	public  UserDetails getUserByName(@PathVariable (value="userName")String userName)
	{
		return userDetailsDao.findByUserName(userName);
	}
	
	@PutMapping("/{userName}")
	public ResponseEntity<?> updateUser(@PathVariable (value="userName")String userName, @RequestBody UserDetails userDetails)
	{
		try {
			UserDetails userByName = userDetailsDao.findByUserName(userName);
			userByName.setUserName(userDetails.getUserName());
			userByName.setFullName(userDetails.getFullName());
			userByName.setRole(userDetails.getRole());
			userByName.setContact(userDetails.getContact());

			return ResponseEntity.ok(userDetailsDao.save(userByName));
		}
		catch (Exception ex)
		{
			return ResponseEntity.noContent().build();
		}

	}

	@DeleteMapping("/{userName}")
	public ResponseEntity<?> deleteUserByName(@PathVariable (value="userName")String userName)
	{
		try
		{
			UserDetails user = userDetailsDao.findByUserName(userName);
			userDetailsDao.delete(user);
			return ResponseEntity.ok(true);
		}
		catch (Exception ex)
		{
			return ResponseEntity.noContent().build();
		}
	}

}
