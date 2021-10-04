package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.OtherProductDto;
import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.ProductType;
import com.example.bookstoreSystem.service.OtherProductService;

@RestController
public class OtherProductController {

	@Autowired
	private OtherProductService otherProductService;
	
	@GetMapping(value = "/getAllOtherProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OtherProductDto>> findAllOtherProducts() {
		if(otherProductService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<OtherProductDto> otherProductsDto = new ArrayList<OtherProductDto>();
		otherProductService.findAll().forEach(otherProduct -> otherProductsDto.add(new OtherProductDto(otherProduct)));
		
		return new ResponseEntity<List<OtherProductDto>>(otherProductsDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOtherProductById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OtherProductDto> findOtherProductById(@PathVariable("id") Long id) {
		if(otherProductService.findOneById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<OtherProductDto>(new OtherProductDto(otherProductService.findOneById(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOtherProductByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OtherProductDto> findOtherProductByName(@PathVariable("name") String name) {
		if(otherProductService.findOneByName(name) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<OtherProductDto>(new OtherProductDto(otherProductService.findOneByName(name)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOtherProductByCode/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OtherProductDto> findOtherProductByCode(@PathVariable("code") String code) {
		if(otherProductService.findOneByCode(code) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<OtherProductDto>(new OtherProductDto(otherProductService.findOneByCode(code)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOtherProductsByType/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OtherProductDto>> findOtherProductsByType(@PathVariable("type") ProductType type) { 
		if(otherProductService.findAllByType(type) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<OtherProductDto> otherProductsDto = new ArrayList<OtherProductDto>();
		otherProductService.findAllByType(type).forEach(otherProduct -> otherProductsDto.add(new OtherProductDto(otherProduct)));
		
		return new ResponseEntity<List<OtherProductDto>>(otherProductsDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createNewOtherProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OtherProduct> createNewOtherProduct(@RequestBody OtherProduct otherProduct) {
		return new ResponseEntity<OtherProduct>(otherProductService.createNew(otherProduct), HttpStatus.CREATED);
	}
}
