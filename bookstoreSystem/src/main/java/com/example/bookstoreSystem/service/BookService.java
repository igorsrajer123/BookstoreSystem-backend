package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BookLanguage;
import com.example.bookstoreSystem.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Book findOneById(Long id) {
		return bookRepository.findOneById(id);
	}
	
	public Book findOneByName(String name) {
		return bookRepository.findOneByName(name);
	}
	
	public Book findOneByCode(String code) {
		return bookRepository.findOneByCode(code);
	}
	
	public List<Book> findAllByPublisherId(Long id) {
		return bookRepository.findAllByPublisherId(id);
	}
	
	public List<Book> findAllByLanguage(BookLanguage language) {
		return bookRepository.findAllByLanguage(language);
	}
	
	public List<Book> findAllByGenreName(String name) {
		return bookRepository.findAllByGenres_Name(name);
	}
}
