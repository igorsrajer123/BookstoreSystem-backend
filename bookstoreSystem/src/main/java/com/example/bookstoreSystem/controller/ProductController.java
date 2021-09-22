package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstoreSystem.model.Product;
import com.example.bookstoreSystem.model.ProductType;
import com.example.bookstoreSystem.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getProductById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		if(productService.findOneById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Product>(productService.findOneById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getProductByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
		if(productService.findOneByName(name) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Product>(productService.findOneByName(name), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getProductByCode/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductByCode(@PathVariable("code") String code) {
		if(productService.findOneByCode(code) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Product>(productService.findOneByCode(code), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getProductsByType/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProductsByType(@PathVariable("type") ProductType type) {
		if(productService.findAllByType(type) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Product>>(productService.findAllByType(type), HttpStatus.OK);
	}
}
