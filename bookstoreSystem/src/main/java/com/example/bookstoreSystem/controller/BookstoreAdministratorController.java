package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.BookstoreAdministratorDto;
import com.example.bookstoreSystem.model.BookstoreAdministrator;
import com.example.bookstoreSystem.service.BookstoreAdministratorService;

@RestController
public class BookstoreAdministratorController {

	@Autowired
	private BookstoreAdministratorService bookstoreAdministratorService;
	
	@GetMapping(value = "/getAllBookstoreAdmins", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookstoreAdministratorDto>> findAll() {
		if(bookstoreAdministratorService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<BookstoreAdministratorDto> adminsDto = new ArrayList<BookstoreAdministratorDto>();
		bookstoreAdministratorService.findAll().forEach(admin -> adminsDto.add(new BookstoreAdministratorDto(admin)));
		
		return new ResponseEntity<List<BookstoreAdministratorDto>>(adminsDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createBookstoreAdmin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookstoreAdministratorDto> createBookstoreAdministrator(@RequestBody BookstoreAdministrator admin) {
		BookstoreAdministrator newAdmin = bookstoreAdministratorService.createNew(admin);
		
		if(newAdmin == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookstoreAdministratorDto>(new BookstoreAdministratorDto(newAdmin), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getBookstoreAdministratorByUserId/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookstoreAdministratorDto> findBookstoreAdministratorByUserId(@PathVariable("id") Long id) {
		if(bookstoreAdministratorService.findOneByUserId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookstoreAdministratorDto>(new BookstoreAdministratorDto(bookstoreAdministratorService.findOneByUserId(id)), HttpStatus.OK);
	}
}
