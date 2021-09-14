package com.example.bookstoreSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.repository.UserRepository;

@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = userRepository.findOneByEmail(email);
		return user;
	}
	
	public User login(User user) {
		User myUser = (User) loadUserByUsername(user.getEmail());
		
		if(myUser == null) return null;
		
		if(myUser != null && !myUser.isActivated()) return null;

		return myUser;
	}
}
