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

import com.example.bookstoreSystem.dto.ReceiptDto;
import com.example.bookstoreSystem.service.ReceiptService;

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
}
