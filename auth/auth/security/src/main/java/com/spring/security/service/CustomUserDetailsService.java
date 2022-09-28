package com.spring.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.entity.User;
import com.spring.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository repository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUserName(username);
		return  new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), (Collection<? extends GrantedAuthority>) new ArrayList<Object>());
	}
	
	
	
	public String createUser(User user) {
		repository.save(user);
		return "Data Saved";
	}
	
	

	
}
