package com.javabrains.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.springsecurityjwt.entity.AuthenticationRequest;
import com.javabrains.springsecurityjwt.entity.AuthenticationResponse;
import com.javabrains.springsecurityjwt.serviceimpl.MyUserServiceImp;
import com.javabrains.springsecurityjwt.util.JwtUtil;

@RestController
public class JwtController {
     
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserServiceImp myservice;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@RequestMapping(value="/authenticate" , method= RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authrequest)  throws Exception
	{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authrequest.getUsername(),authrequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("username or password is wrong ",e);
		}
		final UserDetails userDetails = myservice.loadUserByUsername(authrequest.getUsername());
		
		final String jwt = jwtutil.generateToken(userDetails);
		
		return ResponseEntity.status(200).body(new AuthenticationResponse(jwt));
	}
	
}
