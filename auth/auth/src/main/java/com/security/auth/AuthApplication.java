package com.security.auth;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.auth.entity.User;
import com.security.auth.repository.UserRepository;

@SpringBootApplication
public class AuthApplication {

	@Autowired
	UserRepository repository;

	@PostConstruct
	public void initUsers() {

		User admin = new User(100, "Amrutkar", "da", "admin@gmail.com", "Admin");
		User use1 = new User(111, "dhiraj", "dpa", "dhirajpamrutkar@gmail.com", "User");
		User use2 = new User(222, "Anushka", "anu", "anushkapamrutkar@gmail.com", "User");
		repository.save(admin);
		repository.save(use1);
		repository.save(use2);
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
