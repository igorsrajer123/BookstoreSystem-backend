package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();
	
	User findOneByEmail(String email);
	
	User findOneById(Long id);
}
