package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Authority;
import com.example.bookstoreSystem.model.Customer;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.repository.CustomerRepository;
import com.example.bookstoreSystem.repository.UserRepository;

@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
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
	
	public Customer register(Customer customer) {
		if(loadUserByUsername(customer.getUser().getEmail()) != null) return null;
		
		customer.getUser().setPassword(passwordEncoder.encode(customer.getUser().getPassword()));
		customer.getUser().setEnabled(true);
		customer.getUser().setActivated(false);
		customer.getUser().setType("ROLE_CUSTOMER");
		customer.getUser().setFirstLogin(false);
		customer.setProcessed(false);
		List<Authority> authorities = authorityService.findByName("ROLE_CUSTOMER");
		customer.getUser().setAuthorities(authorities);
		customerRepository.save(customer);
		
		return customer;
	}
}
