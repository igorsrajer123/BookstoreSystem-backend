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

import com.example.bookstoreSystem.dto.WriterDto;
import com.example.bookstoreSystem.service.WriterService;

@RestController
public class WriterController {

	@Autowired
	private WriterService writerService;
	
	@GetMapping(value = "/getAllWriters", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WriterDto>> getAllWriters() {	
		if(writerService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<WriterDto> writersDto = new ArrayList<WriterDto>();
		writerService.findAll().forEach(writer -> writersDto.add(new WriterDto(writer)));
		
		return new ResponseEntity<List<WriterDto>>(writersDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookWriters/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WriterDto>> getBookWriters(@PathVariable("bookName") String name) {
		if(writerService.findAllByBookName(name) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<WriterDto> writersDto = new ArrayList<WriterDto>();
		writerService.findAllByBookName(name).forEach(writer -> writersDto.add(new WriterDto(writer)));
		
		return new ResponseEntity<List<WriterDto>>(writersDto , HttpStatus.OK);
	}
}
