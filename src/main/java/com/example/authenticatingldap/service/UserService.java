package com.example.authenticatingldap.service;

import com.example.authenticatingldap.model.User;
import com.example.authenticatingldap.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
