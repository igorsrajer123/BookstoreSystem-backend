package com.example.bookstoreSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.dto.GenreDto;
import com.example.bookstoreSystem.model.Genre;
import com.example.bookstoreSystem.service.GenreService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	
	@GetMapping(value = "/getAllGenres", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GenreDto>> getAllGenres() {
		if(genreService.findAll() == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<GenreDto> genresDto = new ArrayList<GenreDto>();
		genreService.findAll().forEach(genre -> genresDto.add(new GenreDto(genre)));
		
		return new ResponseEntity<List<GenreDto>>(genresDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getGenreById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDto> getGenreById(@PathVariable("id") Long id) {
		if(genreService.findOneById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<GenreDto>(new GenreDto(genreService.findOneById(id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getGenreByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDto> getGenreByName(@PathVariable("name") String name) {
		if(genreService.findOneByName(name) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<GenreDto>(new GenreDto(genreService.findOneByName(name)), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_SYSTEM_ADMIN')")
	@PostMapping(value = "/createNewGenre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDto> createNewGenre(@RequestBody Genre genre) {
		return new ResponseEntity<GenreDto>(new GenreDto(genreService.createNew(genre)), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_SYSTEM_ADMIN')")
	@PutMapping(value = "/editGenre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreDto> editGenre(@RequestBody Genre genre) {
		return new ResponseEntity<GenreDto>(new GenreDto(genreService.editGenre(genre)), HttpStatus.OK);
	}
}
