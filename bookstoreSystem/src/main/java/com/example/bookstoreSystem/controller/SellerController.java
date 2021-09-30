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
import com.example.bookstoreSystem.model.Seller;
import com.example.bookstoreSystem.service.SellerService;

@RestController
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@GetMapping(value = "/getAllSellers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Seller>> findAll() {
		return new ResponseEntity<List<Seller>>(sellerService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/createBookstoreSeller", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seller> createBookstoreAdministrator(@RequestBody Seller seller) {
		Seller a = sellerService.createNew(seller);
		
		if(a == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Seller>(a, HttpStatus.CREATED);
	}
}
