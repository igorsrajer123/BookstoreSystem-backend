package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.Customer;
import com.example.bookstoreSystem.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCustomerByUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerByUser(@PathVariable("userId") Long id) {
		return new ResponseEntity<Customer>(customerService.findOneByUserId(id), HttpStatus.OK);
	}
}
