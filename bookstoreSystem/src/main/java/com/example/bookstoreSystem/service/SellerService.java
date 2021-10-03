package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Authority;
import com.example.bookstoreSystem.model.Seller;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.repository.SellerRepository;
import com.example.bookstoreSystem.repository.UserRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private BookstoreService bookstoreService;
	
	public List<Seller> findAll() {
		return sellerRepository.findAll();
	}
	
	public Seller findOneById(Long id) {
		return sellerRepository.findOneById(id);
	}
	
	public Seller findOneByUserId(Long id) {
		return sellerRepository.findOneByUserId(id);
	}
	
	public Seller createNew(Seller seller) {
		if(userRepository.findOneByEmail(seller.getUser().getEmail()) != null) return null;
		
		Seller newSeller = new Seller();
		User newUser = new User();
		newUser.setEmail(seller.getUser().getEmail());
		newUser.setPassword(passwordEncoder.encode(seller.getUser().getPassword()));
		newUser.setFirstName(seller.getUser().getFirstName());
		newUser.setLastName(seller.getUser().getLastName());
		newUser.setPhoneNumber(seller.getUser().getPhoneNumber());
		newUser.setAddress(seller.getUser().getAddress());
		newUser.setCity(seller.getUser().getCity());
		newUser.setDateOfBirth(seller.getUser().getDateOfBirth());
		newUser.setActivated(true);
		newUser.setEnabled(true);
		newUser.setFirstLogin(true);
		newUser.setType("ROLE_SELLER");
		List<Authority> authorities = authorityService.findByName("ROLE_SELLER");
		newUser.setAuthorities(authorities);
		newSeller.setUser(newUser);
		newSeller.setBookstore(bookstoreService.findOneById(seller.getBookstore().getId()));
		
		return sellerRepository.save(newSeller);
	}
	
	public List<Seller> findAllByBookstoreId(Long id) {
		return sellerRepository.findAllByBookstoreId(id);
	}
}
