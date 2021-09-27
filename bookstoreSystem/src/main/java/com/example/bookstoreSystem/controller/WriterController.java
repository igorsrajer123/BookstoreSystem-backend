package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.Writer;
import com.example.bookstoreSystem.service.WriterService;

@RestController
public class WriterController {

	@Autowired
	private WriterService writerService;
	
	@GetMapping(value = "/getAllWriters", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Writer>> getAllWriters() {
		return new ResponseEntity<List<Writer>>(writerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookWriters/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Writer>> getBookWriters(@PathVariable("bookName") String name) {
		return new ResponseEntity<List<Writer>>(writerService.findAllByBookName(name) , HttpStatus.OK);
	}
}
