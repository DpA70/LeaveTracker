package com.spring.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.spring.security.entity.User;
import com.spring.security.repository.UserRepository;


import javax.annotation.PostConstruct;

@SpringBootApplication
@CrossOrigin
public class SecurityApplication {

	
	@Autowired
	UserRepository repository;
	
	
	@PostConstruct
    public void initUsers() {
        
           User use1 =  new User(101, "dhiraj", "dpa", "dhirajpamrutkar@gmail.com");   
           repository.save(use1);
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
