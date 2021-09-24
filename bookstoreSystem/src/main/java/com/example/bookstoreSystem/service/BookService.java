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
	
	List<Book> findAllByLanguage(BookLanguage language) {
		return bookRepository.findAllByLanguage(language);
	}
}