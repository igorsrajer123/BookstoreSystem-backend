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

import com.example.bookstoreSystem.dto.CashRegisterDto;
import com.example.bookstoreSystem.service.CashRegisterService;

@RestController
public class CashRegisterController {

	@Autowired
	private CashRegisterService cashRegisterService;
	
	@GetMapping(value = "/getAllCashRegisters", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CashRegisterDto>> findAll() {
		if(cashRegisterService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<CashRegisterDto> cashRegistersDto = new ArrayList<CashRegisterDto>();
		cashRegisterService.findAll().forEach(cashRegister -> cashRegistersDto.add(new CashRegisterDto(cashRegister)));
		
		return new ResponseEntity<List<CashRegisterDto>>(cashRegistersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCashRegisterByBookstoreId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CashRegisterDto> findCashRegisterByBookstoreId(@PathVariable("id") Long id) {
		return new ResponseEntity<CashRegisterDto>(new CashRegisterDto(cashRegisterService.findOneByBookstoreId(id)), HttpStatus.OK);
	}
}
