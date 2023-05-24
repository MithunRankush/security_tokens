package com.javabrains.springsecurityjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javabrains.springsecurityjwt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	 @Query(value = "SELECT * FROM Users u WHERE username = :username", nativeQuery = true)
	    public User findByUsername(String username);

}
