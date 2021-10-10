package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.CatalogueItem;
import com.example.bookstoreSystem.service.CatalogueItemService;

@RestController
public class CatalogueItemController {

	@Autowired
	private CatalogueItemService catalogueItemService;
	
	@GetMapping(value = "/getCatalogueItemsByBook/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CatalogueItem>> findAllByBookId(@PathVariable("id") Long id) {
		return new ResponseEntity<List<CatalogueItem>>(catalogueItemService.findAllByBookId(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCatalogueItemsByOtherProduct/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CatalogueItem>> findAllByOtherProductId(@PathVariable("id") Long id) {
		return new ResponseEntity<List<CatalogueItem>>(catalogueItemService.findAllByOtherProductId(id), HttpStatus.OK);
	}
}
