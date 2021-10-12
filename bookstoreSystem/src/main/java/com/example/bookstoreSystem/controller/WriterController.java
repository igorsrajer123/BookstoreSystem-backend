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

import com.example.bookstoreSystem.dto.WriterDto;
import com.example.bookstoreSystem.model.Writer;
import com.example.bookstoreSystem.service.WriterService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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
	
	@GetMapping(value ="/getOneWriterById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WriterDto> getOneWriterById(@PathVariable("id") Long id) {
		if(writerService.findOneById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<WriterDto>(new WriterDto(writerService.findOneById(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookWriters/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WriterDto>> getBookWriters(@PathVariable("bookName") String name) {
		if(writerService.findAllByBookName(name) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<WriterDto> writersDto = new ArrayList<WriterDto>();
		writerService.findAllByBookName(name).forEach(writer -> writersDto.add(new WriterDto(writer)));
		
		return new ResponseEntity<List<WriterDto>>(writersDto , HttpStatus.OK);
	}
	
	@PostMapping(value = "/createNewWriter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WriterDto> createNewWriter(@RequestBody Writer writer) {
		return new ResponseEntity<WriterDto>(new WriterDto(writerService.createNew(writer)), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateWriter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WriterDto> updateWriter(@RequestBody Writer writer) {
		if(writerService.updateWriter(writer) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<WriterDto>(new WriterDto(writerService.updateWriter(writer)), HttpStatus.OK);
	}
	
	@PutMapping(value = "/addWriterNewBook/{bookCode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addWriterNewBook(@PathVariable("bookCode") String code, @RequestBody List<Writer> writers) {
		writerService.addWriterNewBook(code, writers);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping(value = "/findAllWritersByNameContaining/{str}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WriterDto>> getWritersByNameContaining(@PathVariable("str") String str) {
		List<WriterDto> writersDto = new ArrayList<WriterDto>();
		writerService.findAllByNameContaining(str).forEach(writer -> writersDto.add(new WriterDto(writer)));
		
		return new ResponseEntity<List<WriterDto>>(writersDto , HttpStatus.OK);
	}
}
