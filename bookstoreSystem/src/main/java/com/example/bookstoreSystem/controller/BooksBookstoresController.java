package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.BooksBookstores;
import com.example.bookstoreSystem.service.BooksBookstoresService;

@RestController
public class BooksBookstoresController {

	@Autowired
	private BooksBookstoresService booksBookstoresService;
	
	@GetMapping(value = "/getAllBooksInBookstores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BooksBookstores>> findAll(){
		return new ResponseEntity<List<BooksBookstores>>(booksBookstoresService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBooksInBookstore/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BooksBookstores>> getBooksInBookstore(@PathVariable("id") Long id){
		return new ResponseEntity<List<BooksBookstores>>(booksBookstoresService.findAllByBookstoreId(id), HttpStatus.OK);
	}
}