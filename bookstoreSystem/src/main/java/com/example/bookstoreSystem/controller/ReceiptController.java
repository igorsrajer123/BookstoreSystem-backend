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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.ReceiptDto;
import com.example.bookstoreSystem.model.Receipt;
import com.example.bookstoreSystem.model.ReceiptItem;
import com.example.bookstoreSystem.service.ReceiptService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;

	@GetMapping(value = "/getAllReceipts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReceiptDto>> findAll() {
		List<ReceiptDto> receiptsDto = new ArrayList<ReceiptDto>();
		receiptService.findAll().forEach(receipt -> receiptsDto.add(new ReceiptDto(receipt)));
		
		return new ResponseEntity<List<ReceiptDto>>(receiptsDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCashRegistersReceipts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReceiptDto>> findReceiptsByCashRegisterId(@PathVariable("id") Long id) {
		if(receiptService.findAllByCashRegisterId(id) == null) return new ResponseEntity<>(HttpStatus.OK);
		
		List<ReceiptDto> receiptsDto = new ArrayList<ReceiptDto>();
		receiptService.findAllByCashRegisterId(id).forEach(receipt -> receiptsDto.add(new ReceiptDto(receipt)));
		
		return new ResponseEntity<List<ReceiptDto>>(receiptsDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createReceipt/{sellerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Receipt> createReceipt(@PathVariable("sellerId") Long id, @RequestBody List<ReceiptItem> items) {
		return new ResponseEntity<Receipt>(receiptService.createNew(id, items), HttpStatus.OK);
	}
	
	@PutMapping(value = "/reverseReceipt/{receiptId}/{bookstoreId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Receipt> reverseReceipt(@PathVariable("receiptId") Long receiptId, @PathVariable("bookstoreId") Long bookstoreId) {
		return new ResponseEntity<Receipt>(receiptService.reverseReceipt(receiptId, bookstoreId), HttpStatus.OK);
	}
}
