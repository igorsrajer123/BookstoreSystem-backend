package com.example.bookstoreSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.Customer;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.service.CustomerService;
import com.example.bookstoreSystem.service.EmailService;
import com.example.bookstoreSystem.service.UserService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value = "/sendAccountConfirmation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendAccountConfirmationEmail(@RequestBody String email) {
		try {
			emailService.sendConfirmationEmail(email);
		}catch (MailException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("Email sent!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/activateAccount/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> activateAccount(@PathVariable("userId") String userId) {
		Customer myCustomer = customerService.findOneByUserId((long)Integer.parseInt(userId));
		myCustomer.getUser().setActivated(true);
		myCustomer.setProcessed(true);
		customerService.save(myCustomer);
		
		return new ResponseEntity<String>("Account successfully activated! :)", HttpStatus.OK);
	}
	
	@PostMapping(value = "/sendPasswordRestart/{email}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendPasswordRestart(@PathVariable("email") String email) {
		try {
			emailService.sendPasswordRestartEmail(email);
		}catch (MailException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("Email sent!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/restartPassword/{email}/{password}")
	public ResponseEntity<String> restartPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
		User myUser = userService.findOneByEmail(email);
		myUser.setPassword(password);
		userService.save(myUser);
		
		return new ResponseEntity<String>("Password successfully restarted! :)", HttpStatus.OK);
	}
}
