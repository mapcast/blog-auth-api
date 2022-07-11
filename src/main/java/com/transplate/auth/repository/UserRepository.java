package com.transplate.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transplate.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserIdAndUserPasswordAndIsDeletedFalse(String userId, String userPassword); 
	
	Optional<User> findByUserAndIsDeletedFalse(String userId);
}
