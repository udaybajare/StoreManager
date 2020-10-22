package com.storemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.dao.UserDetailsDao;
import com.storemanager.entity.UserDetails;

@RestController
@RequestMapping("/api")
public class UserDetailsController {
	
	@Autowired
	UserDetailsDao userDetailsDao;

	@PostMapping("/register")
	public UserDetails saveUser(@RequestBody UserDetails userDetails )
	{
			return userDetailsDao.save(userDetails);
	}
	
	@GetMapping("/getUser/{userName}")
	public  UserDetails getUserByName(@PathVariable (value="userName")String userName)
	{
		return userDetailsDao.findByUserName(userName);
	}
	
	@GetMapping("/updateUser/{userName}")
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

	@RequestMapping(value="/deleteUser/{userName}" ,method = RequestMethod.DELETE)
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
