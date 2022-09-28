package com.security.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.auth.entity.AuthJWTResponse;
import com.security.auth.entity.AuthRequest;
import com.security.auth.entity.User;
import com.security.auth.repository.UserRepository;
import com.security.auth.util.JwtUtil;

@Service
public class CustomUserDetailsService implements UserDetailsService {
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
