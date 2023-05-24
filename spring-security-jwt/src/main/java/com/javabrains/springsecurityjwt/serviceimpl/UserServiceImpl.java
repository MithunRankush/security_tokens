package com.javabrains.springsecurityjwt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javabrains.springsecurityjwt.dao.UserRepository;
import com.javabrains.springsecurityjwt.entity.User;
import com.javabrains.springsecurityjwt.service.UserService;

public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userrepo;

@Override
public List<User> getAll() {
	return userrepo.findAll();
}

@Override
public User signup(User user) {
	return userrepo.save(user);
}

@Override
public User login(String username, String password) {
     User user = userrepo.findByUsername(username);
     if(user.getPassword().equals(password)) {
    	 return user;
     }
	return null;
}
}
