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

import com.example.bookstoreSystem.model.OtherProductsBookstores;
import com.example.bookstoreSystem.service.OtherProductsBookstoresService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class OtherProductsBookstoresController {

	@Autowired
	private OtherProductsBookstoresService otherProductsBookstoresService;
	
	@GetMapping(value = "/getAllOtherProductsInBookstores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OtherProductsBookstores>> findAll() {
		return new ResponseEntity<List<OtherProductsBookstores>>(otherProductsBookstoresService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOtherProductsInBookstore/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OtherProductsBookstores>> findOtherProductsInBookstore(@PathVariable("id") Long id) {
		return new ResponseEntity<List<OtherProductsBookstores>>(otherProductsBookstoresService.findAllByBookstoreId(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateOtherProductsBookstoresAmount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OtherProductsBookstores> updateOtherProductsBookstoresAmount(@RequestBody OtherProductsBookstores otherProductsBookstores) {
		if(otherProductsBookstoresService.updateOtherProductsBookstoresAmount(otherProductsBookstores) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<OtherProductsBookstores>(otherProductsBookstoresService.updateOtherProductsBookstoresAmount(otherProductsBookstores), HttpStatus.OK);
	}
	
	@GetMapping(value = "/checkOtherProductAvailableInBookstore/{bookstoreId}/{otherProductId}/{amount}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkOtherProductAvailable(@PathVariable("bookstoreId") Long bookstoreId, @PathVariable("otherProductId") Long otherProductId, @PathVariable("amount") int amount) {
		if(otherProductsBookstoresService.checkOtherProductAmountAvailable(bookstoreId, otherProductId, amount) == false) return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
