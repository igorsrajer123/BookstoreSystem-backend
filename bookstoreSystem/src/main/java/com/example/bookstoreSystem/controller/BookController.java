package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.BookDto;
import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.service.BookService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getAllBooks() {
		if(bookService.findAll() == null)  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<BookDto> booksDto = new ArrayList<BookDto>();
		bookService.findAll().forEach(book -> booksDto.add(new BookDto(book)));
		
		return new ResponseEntity<List<BookDto>>(booksDto, HttpStatus.OK); 
	}
	
	@GetMapping(value = "/getBookById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id) {
		if(bookService.findOneById(id) == null) return new ResponseEntity<BookDto>(new BookDto(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookDto>(new BookDto(bookService.findOneById(id)), HttpStatus.OK); 
	}
	
	@GetMapping(value = "/getBookByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookByName(@PathVariable("name") String name) {
		if(bookService.findOneByName(name) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookDto>(new BookDto(bookService.findOneByName(name)), HttpStatus.OK); 
	}
	
	@GetMapping(value = "/getBookByCode/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookByCode(@PathVariable("code") String code) {
		if(bookService.findOneByCode(code) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookDto>(new BookDto(bookService.findOneByCode(code)), HttpStatus.OK); 
	}
	
	@GetMapping(value = "/getBooksByGenre/{genreName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getBooksByGenre(@PathVariable("genreName") String name) {
		if(bookService.findAllByGenreName(name) == null)  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<BookDto> booksDto = new ArrayList<BookDto>();
		bookService.findAllByGenreName(name).forEach(book -> booksDto.add(new BookDto(book)));
		
		return new ResponseEntity<List<BookDto>>(booksDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createNewBook",  produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> createNewBook(@RequestBody Book book) {
		return new ResponseEntity<BookDto>(new BookDto(bookService.createNew(book)), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateBook", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> updateBook(@RequestBody Book book) {
		if(bookService.updateBook(book) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookDto>(new BookDto(bookService.updateBook(book)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookByBooksInBookstoreId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookByBooksInBookstoreId(@PathVariable("id") Long id) {
		return new ResponseEntity<BookDto>(new BookDto(bookService.findOneByBooksInBookstoreId(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookFromReceiptItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookByReceiptItemId(@PathVariable("id") Long id) {
		if(bookService.findOneByReceiptItemId(id) == null) return new ResponseEntity<BookDto>(new BookDto(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookDto>(new BookDto(bookService.findOneByReceiptItemId(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookFromShoppingCartItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookByShoppingCartItemId(@PathVariable("id") Long id) {
		if(bookService.findOneByShoppingCartItem(id) == null) return new ResponseEntity<BookDto>(new BookDto(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookDto>(new BookDto(bookService.findOneByShoppingCartItem(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookFromDeliveryItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBookByDeliveryItemId(@PathVariable("id") Long id) {
		if(bookService.findOneByDeliveryItem(id) == null) return new ResponseEntity<BookDto>(new BookDto(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<BookDto>(new BookDto(bookService.findOneByDeliveryItem(id)), HttpStatus.OK);
	}
}
