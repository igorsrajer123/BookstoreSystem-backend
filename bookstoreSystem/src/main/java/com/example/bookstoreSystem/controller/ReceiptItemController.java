package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstoreSystem.model.ReceiptItem;
import com.example.bookstoreSystem.service.ReceiptItemService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ReceiptItemController {

	@Autowired
	private ReceiptItemService receiptItemService;
	
	@GetMapping(value = "/getAllReceiptItems", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReceiptItem>> findAll() {
		if(receiptItemService.findAll() == null) return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<List<ReceiptItem>>(receiptItemService.findAll() , HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getReceiptItems/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReceiptItem>> findAllReceiptItems(@PathVariable("id") Long id) {
		if(receiptItemService.findAllByReceiptId(id) == null) return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<List<ReceiptItem>>(receiptItemService.findAllByReceiptId(id), HttpStatus.OK);
	}
}
