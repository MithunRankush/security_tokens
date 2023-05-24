package com.javabrains.springsecurityjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.springsecurityjwt.entity.User;
import com.javabrains.springsecurityjwt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
   
	@Autowired
	UserService userservice;
	
	@RequestMapping("/getall")
	public ResponseEntity<List<User>> getAll(){
		List<User> list = userservice.getAll();
		if(list!= null && list.size()>0) {
			return ResponseEntity.status(200).body(list);
		}
		return ResponseEntity.status(400).body(list);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody User user){
		User u = userservice.signup(user);
		if(u!=null) {
			return ResponseEntity.status(200).body(u);
		}
		return ResponseEntity.status(400).body(u);
	}
	
	@GetMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader String username,@RequestHeader String password)
    { 
    	if(userservice.login(username, password) instanceof User)
    	{
    		return ResponseEntity.status(200).body(userservice.login(username, password));
    	}
    	return ResponseEntity.status(400).body(userservice.login(username, password)); 
    }
	
}
