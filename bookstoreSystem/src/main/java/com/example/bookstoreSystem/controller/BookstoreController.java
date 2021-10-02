package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.BookstoreDto;
import com.example.bookstoreSystem.service.BookstoreService;

@RestController
public class BookstoreController {

	@Autowired
	private BookstoreService bookstoreService;
	
	@GetMapping(value = "/getAllBookstores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookstoreDto>> getAllBookstores() {
		if(bookstoreService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<BookstoreDto> bookstoresDto = new ArrayList<BookstoreDto>();
		bookstoreService.findAll().forEach(bookstore -> bookstoresDto.add(new BookstoreDto(bookstore)));
		
		return new ResponseEntity<List<BookstoreDto>>(bookstoresDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookstoreById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookstoreDto> getBookstoreById(@PathVariable("id") Long id) {
		if(bookstoreService.findOneById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookstoreDto>(new BookstoreDto(bookstoreService.findOneById(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookstoreByAdminId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookstoreDto> getBookstoreByAdminId(@PathVariable("id") Long id) {
		if(bookstoreService.findOneByBookstoreAdministratorId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookstoreDto>(new BookstoreDto(bookstoreService.findOneByBookstoreAdministratorId(id)), HttpStatus.OK);
	}
}
