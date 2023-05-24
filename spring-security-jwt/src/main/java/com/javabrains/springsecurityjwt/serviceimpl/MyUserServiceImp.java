package com.javabrains.springsecurityjwt.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javabrains.springsecurityjwt.dao.UserRepository;
import com.javabrains.springsecurityjwt.entity.User;

public class MyUserServiceImp implements UserDetailsService {
	
	  @Autowired
	  UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userrepo.findByUsername(username);
		if(username.equals(u.getUsername())) {
			return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),new ArrayList<>());
		}else {
			throw  new UsernameNotFoundException("user not found");
		}
	
	}


}
