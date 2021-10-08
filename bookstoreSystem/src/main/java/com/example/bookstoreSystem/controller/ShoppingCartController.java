package com.example.bookstoreSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.ShoppingCart;
import com.example.bookstoreSystem.service.ShoppingCartService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping(value = "/getShoppingCartByUserId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCart> findOneByUserId(@PathVariable("id") Long id) {
		if(shoppingCartService.findOneByCustomerId(id) == null) return new ResponseEntity<ShoppingCart>(new ShoppingCart(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ShoppingCart>(shoppingCartService.findOneByCustomerId(id), HttpStatus.OK);
	}
}
