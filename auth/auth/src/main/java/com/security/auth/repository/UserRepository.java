package com.security.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.auth.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
	 User findByUserName(String username);
}
