package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Authority;
import com.example.bookstoreSystem.model.BookstoreAdministrator;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.repository.BookstoreAdministratorRepository;
import com.example.bookstoreSystem.repository.UserRepository;

@Service
public class BookstoreAdministratorService {

	@Autowired
	private BookstoreAdministratorRepository bookstoreAdministratorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private BookstoreService bookstoreService;
	
	public List<BookstoreAdministrator> findAll() {
		return bookstoreAdministratorRepository.findAll();
	}
	
	public BookstoreAdministrator findOneById(Long id) {
		return bookstoreAdministratorRepository.findOneById(id);
	}
	
	public BookstoreAdministrator findOneByUserId(Long id) {
		return bookstoreAdministratorRepository.findOneByUserId(id);
	}
	
	public BookstoreAdministrator createNew(BookstoreAdministrator admin) {
		if(userRepository.findOneByEmail(admin.getUser().getEmail()) != null) return null;
		
		BookstoreAdministrator newAdmin = new BookstoreAdministrator();
		User newUser = new User();
		newUser.setEmail(admin.getUser().getEmail());
		newUser.setPassword(passwordEncoder.encode(admin.getUser().getPassword()));
		newUser.setFirstName(admin.getUser().getFirstName());
		newUser.setLastName(admin.getUser().getLastName());
		newUser.setPhoneNumber(admin.getUser().getPhoneNumber());
		newUser.setAddress(admin.getUser().getAddress());
		newUser.setCity(admin.getUser().getCity());
		newUser.setDateOfBirth(admin.getUser().getDateOfBirth());
		newUser.setActivated(true);
		newUser.setEnabled(true);
		newUser.setFirstLogin(true);
		newUser.setType("ROLE_BOOKSTORE_ADMIN");
		List<Authority> authorities = authorityService.findByName("ROLE_BOOKSTORE_ADMIN");
		newUser.setAuthorities(authorities);
		newAdmin.setUser(newUser);
		newAdmin.setBookstore(bookstoreService.findOneById(admin.getBookstore().getId()));
		
		return bookstoreAdministratorRepository.save(newAdmin);
	}
}
