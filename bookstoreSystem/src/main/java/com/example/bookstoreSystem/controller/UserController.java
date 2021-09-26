package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.service.UserService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		if(userService.findOneById(id) == null) return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userService.findOneById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUserByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		if(userService.findOneByEmail(email) == null) return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userService.findOneByEmail(email), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateUserInformation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUserInformation(@RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUserInformation(user), HttpStatus.OK);
	}
}
