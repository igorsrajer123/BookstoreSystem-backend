package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bookstoreSystem.model.ShoppingCartItem;
import com.example.bookstoreSystem.service.ShoppingCartItemService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class ShoppingCartItemController {

	@Autowired
	private ShoppingCartItemService shoppingCartItemService;
	
	@PostMapping(value = "/createNewShoppingCartItem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCartItem> createNewShoppingCartItem(@RequestBody ShoppingCartItem item) {
		return new ResponseEntity<ShoppingCartItem>(shoppingCartItemService.createNew(item), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getShoppingCartItems/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ShoppingCartItem>> getShoppingCartItems(@PathVariable("id") Long id) {
		return new ResponseEntity<List<ShoppingCartItem>>(shoppingCartItemService.findAllByShoppingCartId(id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteShoppingCartItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createNewShoppingCartItem(@PathVariable("id") Long id) {
		return new ResponseEntity<Long>(shoppingCartItemService.deleteItem(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/checkItemAvailable/{id}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkItemAvailable(@PathVariable("id") Long id, @PathVariable("amount") int amount) {
		return new ResponseEntity<Boolean>(shoppingCartItemService.checkIfItemAvailable(id, amount), HttpStatus.OK);
	}
}
