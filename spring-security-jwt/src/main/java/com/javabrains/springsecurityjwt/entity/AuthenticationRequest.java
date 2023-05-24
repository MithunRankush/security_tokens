package com.javabrains.springsecurityjwt.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class AuthenticationRequest implements Serializable {
     String username;
     String password;
     
}
