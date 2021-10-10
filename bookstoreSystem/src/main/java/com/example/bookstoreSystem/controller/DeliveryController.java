package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.DeliveryDto;
import com.example.bookstoreSystem.model.Delivery;
import com.example.bookstoreSystem.service.DeliveryService;
import com.example.bookstoreSystem.service.EmailService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping(value = "/getAllDeliveries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeliveryDto>> findAll() {
		List<DeliveryDto> allDeliveriesDto = new ArrayList<DeliveryDto>();
		
		deliveryService.findAll().forEach(d -> allDeliveriesDto.add(new DeliveryDto(d)));
		
		return new ResponseEntity<List<DeliveryDto>>(allDeliveriesDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createDelivery", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliveryDto> createDelivery(@RequestBody Delivery delivery) {
		return new ResponseEntity<DeliveryDto>(new DeliveryDto(deliveryService.createNew(delivery)), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/declineDelivery/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliveryDto> declineDelivery(@PathVariable("id") Long id) throws MailException, InterruptedException {
		emailService.deliveryDeclined();
		return new ResponseEntity<DeliveryDto>(new DeliveryDto(deliveryService.declineDelivery(id)), HttpStatus.OK);
	}
	
	@PutMapping(value = "/acceptDelivery/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliveryDto> acceptDelivery(@PathVariable("id") Long id) throws MailException, InterruptedException {
		emailService.deliveryAccepted(id);
		return new ResponseEntity<DeliveryDto>(new DeliveryDto(deliveryService.acceptDelivery(id)), HttpStatus.OK);
	}
}
