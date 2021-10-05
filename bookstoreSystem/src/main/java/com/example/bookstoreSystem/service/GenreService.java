package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Genre;
import com.example.bookstoreSystem.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}
	
	public Genre findOneById(Long id) {
		return genreRepository.findOneById(id);
	}
	
	public Genre findOneByName(String name) {
		return genreRepository.findOneByName(name);
	}
	
	public Genre createNew(Genre genre) {
		Genre newGenre = new Genre();
		newGenre.setName(genre.getName());
		genreRepository.save(newGenre);
		
		return newGenre;
	}

	public Genre editGenre(Genre genre) {
		Genre myGenre = genreRepository.findOneById(genre.getId());
		myGenre.setName(genre.getName());
		genreRepository.save(myGenre);
		
		return myGenre;
	}
}
