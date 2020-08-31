package com.storemanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.storemanager.dao.LoginDao;
import com.storemanager.entity.LoginDetails;
import com.storemanager.entity.LoginInfo;

@Service
public class LoginDetailService implements UserDetailsService {

	@Autowired
	LoginDao loginDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<LoginInfo> loginInfo = loginDao.findByUsername(username);

		loginInfo.orElseThrow(() -> new UsernameNotFoundException("Not found: "
				+ username));
		return loginInfo.map(LoginDetails::new).get();
	}

}
