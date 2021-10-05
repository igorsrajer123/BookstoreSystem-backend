package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.UserDto;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.service.EmailService;
import com.example.bookstoreSystem.service.UserService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto>> getAllUsers() {
		if(userService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<UserDto> usersDto = new ArrayList<UserDto>();
		userService.findAll().forEach(user -> usersDto.add(new UserDto(user)));
		
		return new ResponseEntity<List<UserDto>>(usersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
		if(userService.findOneById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<UserDto>(new UserDto(userService.findOneById(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUserByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
		if(userService.findOneByEmail(email) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<UserDto>(new UserDto(userService.findOneByEmail(email)), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_SYSTEM_ADMIN', 'ROLE_CUSTOMER', 'ROLE_BOOKSTORE_ADMIN', 'ROLE_SELLER')")
	@PutMapping(value = "/updateUserInformation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUserInformation(@RequestBody User user) {
		if(userService.updateUserInformation(user) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<User>(userService.updateUserInformation(user), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_SYSTEM_ADMIN', 'ROLE_CUSTOMER', 'ROLE_BOOKSTORE_ADMIN', 'ROLE_SELLER')")
	@PutMapping(value = "/changePassword", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> changePassword(@RequestBody User user) {
		if(userService.changePassword(user) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userService.changePassword(user), HttpStatus.OK);
	}
	
	@PutMapping(value = "/disableAccount/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> disableAccount(@PathVariable("id") Long id) {
		if(userService.disableUserAccount(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		try {
			emailService.accountDisabledNotification();
		} catch (MailException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<UserDto>(new UserDto(userService.disableUserAccount(id)), HttpStatus.OK);
	}
	
	@PutMapping(value = "/enableAccount/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> enableAccount(@PathVariable("id") Long id) {
		if(userService.enableUserAccount(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		try {
			emailService.accountEnabledNotification();
		} catch (MailException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<UserDto>(new UserDto(userService.enableUserAccount(id)), HttpStatus.OK);
	}
}
