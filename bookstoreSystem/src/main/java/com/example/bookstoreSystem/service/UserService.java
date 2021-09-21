package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findOneById(Long id) {
		return userRepository.findOneById(id);
	}
	
	public User findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
