package com.security.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.auth.entity.AuthJWTResponse;
import com.security.auth.entity.AuthRequest;
import com.security.auth.entity.User;
import com.security.auth.repository.UserRepository;
import com.security.auth.service.CustomUserDetailsService;
import com.security.auth.util.JwtUtil;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("hello")
	public String SayHello() {
		return "Hello welcome from spring Security!! ";
	}

	@PostMapping("/create")
	public String CreateUser(@RequestBody User user) {
		return customUserDetailsService.createUser(user);
	}

	@PostMapping("/authenticate")
	public AuthJWTResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		User user = new User();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		String token = jwtUtil.generateToken(authRequest.getUserName());
		
		user = userRepo.findByUserName(authRequest.getUserName());
		return new AuthJWTResponse(user, token);
	}
}
