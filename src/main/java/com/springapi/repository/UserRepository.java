package com.springapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springapi.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT FROM User WHERE email = ?1 AND passoword = ?2")
	public Optional<User> login(String email, String password);
	
}