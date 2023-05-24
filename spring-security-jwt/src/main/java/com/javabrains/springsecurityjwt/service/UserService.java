package com.javabrains.springsecurityjwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javabrains.springsecurityjwt.entity.User;

@Service
public interface UserService {

	List<User> getAll();

	User signup(User user);

	User login(String username, String password);

}
