package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.DeliveryItem;
import com.example.bookstoreSystem.service.DeliveryItemService;

@RestController
public class DeliveryItemController {

	@Autowired
	private DeliveryItemService deliveryItemService;
	
	@GetMapping(value = "/getDeliveryItemsByDeliveryId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeliveryItem>> findDeliveryItemsByDelivery(@PathVariable("id") Long id) {
		return new ResponseEntity<List<DeliveryItem>>(deliveryItemService.findallByDeliveryId(id), HttpStatus.OK);
	}
}
