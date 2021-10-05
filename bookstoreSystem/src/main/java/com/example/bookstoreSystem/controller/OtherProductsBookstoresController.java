package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.OtherProductsBookstores;
import com.example.bookstoreSystem.service.OtherProductsBookstoresService;

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
}
