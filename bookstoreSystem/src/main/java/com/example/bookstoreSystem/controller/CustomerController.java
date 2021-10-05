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

import com.example.bookstoreSystem.dto.CustomerDto;
import com.example.bookstoreSystem.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerDto>> getAllCustomers() {
		if(customerService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<CustomerDto> customersDto = new ArrayList<CustomerDto>();
		customerService.findAll().forEach(customer -> customersDto.add(new CustomerDto(customer)));
		
		return new ResponseEntity<List<CustomerDto>>(customersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCustomerByUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDto> getCustomerByUser(@PathVariable("userId") Long id) {
		if(customerService.findOneByUserId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<CustomerDto>(new CustomerDto(customerService.findOneByUserId(id)), HttpStatus.OK);
	}
}
