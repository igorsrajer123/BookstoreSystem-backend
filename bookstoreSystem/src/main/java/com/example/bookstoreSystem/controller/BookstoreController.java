package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.Bookstore;
import com.example.bookstoreSystem.service.BookstoreService;

@RestController
public class BookstoreController {

	@Autowired
	private BookstoreService bookstoreService;
	
	@GetMapping(value = "/getAllBookstores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bookstore>> getAllBookstores() {
		return new ResponseEntity<List<Bookstore>>(bookstoreService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookstoreById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bookstore> getBookstoreById(@PathVariable("id") Long id) {
		return new ResponseEntity<Bookstore>(bookstoreService.findOneById(id), HttpStatus.OK);
	}
}
