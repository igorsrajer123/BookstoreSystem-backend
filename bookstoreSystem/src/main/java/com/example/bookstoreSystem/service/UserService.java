package com.example.bookstoreSystem.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.common.TimeProvider;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TimeProvider timeProvider;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
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
	
	public User updateUserInformation(User user) {
		User myUser = userRepository.findOneById(user.getId());
		
		if(myUser == null)
			return null;
		
		myUser.setFirstName(user.getFirstName());
		myUser.setLastName(user.getLastName());
		myUser.setPhoneNumber(user.getPhoneNumber());
		myUser.setAddress(user.getAddress());
		myUser.setCity(user.getCity());
		myUser.setDateOfBirth(user.getDateOfBirth());
		userRepository.save(myUser);
		
		return myUser;
	}
	
	public User changePassword(User user) {
		User myUser = userRepository.findOneById(user.getId());
		
		if(myUser == null) 
			return null;
		
		myUser.setPassword(passwordEncoder.encode(user.getPassword()));
		myUser.setLastPasswordResetDate(new Timestamp(timeProvider.now().getTime()));
		userRepository.save(myUser);
		
		return myUser;
	}
}
