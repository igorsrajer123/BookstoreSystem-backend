package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.BookstoreAdministrator;
import com.example.bookstoreSystem.service.BookstoreAdministratorService;

@RestController
public class BookstoreAdministratorController {

	@Autowired
	private BookstoreAdministratorService bookstoreAdministratorService;
	
	@GetMapping(value = "/getAllBookstoreAdmins", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookstoreAdministrator>> findAll() {
		if(bookstoreAdministratorService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<BookstoreAdministrator>>(bookstoreAdministratorService.findAll(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/createBookstoreAdmin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookstoreAdministrator> createBookstoreAdministrator(@RequestBody BookstoreAdministrator admin) {
		BookstoreAdministrator a = bookstoreAdministratorService.createNew(admin);
		
		if(a == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookstoreAdministrator>(a, HttpStatus.CREATED);
	}
}
