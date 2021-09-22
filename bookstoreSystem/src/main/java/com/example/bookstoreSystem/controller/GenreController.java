package com.example.bookstoreSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.model.Genre;
import com.example.bookstoreSystem.service.GenreService;

@RestController
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	
	@GetMapping(value = "/getAllGenres", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Genre>> getAllGenres() {
		return new ResponseEntity<List<Genre>>(genreService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getGenreById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genre> getGenreById(@PathVariable("id") Long id) {
		if(genreService.findOneById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Genre>(genreService.findOneById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getGenreByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genre> getGenreByName(@PathVariable("name") String name) {
		if(genreService.findOneByName(name) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Genre>(genreService.findOneByName(name), HttpStatus.OK);
	}
}
