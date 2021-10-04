package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.PublisherDto;
import com.example.bookstoreSystem.service.PublisherService;

@RestController
public class PublisherController {

	@Autowired
	private PublisherService publisherService;
	
	@GetMapping(value = "/getAllPublishers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PublisherDto>> findAll() {
		if(publisherService.findAll() == null) new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<PublisherDto> publishersDto = new ArrayList<PublisherDto>();
		publisherService.findAll().forEach(publisher -> publishersDto.add(new PublisherDto(publisher)));
		
		return new ResponseEntity<List<PublisherDto>>(publishersDto, HttpStatus.OK);
	}
}
