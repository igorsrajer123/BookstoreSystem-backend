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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.SellerDto;
import com.example.bookstoreSystem.model.Seller;
import com.example.bookstoreSystem.service.SellerService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@GetMapping(value = "/getAllSellers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SellerDto>> findAll() {
		if(sellerService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<SellerDto> sellersDto = new ArrayList<SellerDto>();
		sellerService.findAll().forEach(seller -> sellersDto.add(new SellerDto(seller)));
		
		return new ResponseEntity<List<SellerDto>>(sellersDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createBookstoreSeller", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SellerDto> createSeller(@RequestBody Seller seller) {
		Seller newSeller = sellerService.createNew(seller);
		
		if(newSeller == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<SellerDto>(new SellerDto(newSeller), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllBookstoreSellers/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SellerDto>> findAllBookstoreSellers(@PathVariable("id") Long id) {
		if(sellerService.findAllByBookstoreId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<SellerDto> sellersDto = new ArrayList<SellerDto>();
		sellerService.findAllByBookstoreId(id).forEach(seller -> sellersDto.add(new SellerDto(seller)));
		
		return new ResponseEntity<List<SellerDto>>(sellersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSellerByUserId/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<SellerDto> getSellerByUserId(@PathVariable("id") Long id) {
		if(sellerService.findOneByUserId(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<SellerDto>(new SellerDto(sellerService.findOneByUserId(id)), HttpStatus.OK);
	}
}
