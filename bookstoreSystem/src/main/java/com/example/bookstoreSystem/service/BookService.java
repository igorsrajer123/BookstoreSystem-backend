package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BookLanguage;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.PublisherRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
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
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public Book createNew(Book book) {
		Book newBook = new Book();
		newBook.setCode(book.getCode());
		newBook.setName(book.getName());
		newBook.setNumberOfPages(book.getNumberOfPages());
		newBook.setPrice(book.getPrice());
		newBook.setPublished(book.getPublished());
		newBook.setPublisher(publisherRepository.findOneById(book.getPublisher().getId()));
		newBook.setLanguage(book.getLanguage());
		newBook.setCoverType(book.getCoverType());
		newBook.setDescription(book.getDescription());
		newBook.setGenres(book.getGenres());
		bookRepository.save(newBook);
		
		return newBook;
	}
	
	public Book updateBook(Book book) {
		Book myBook = bookRepository.findOneById(book.getId());
		
		if(myBook == null) return null;
		
		myBook.setName(book.getName());
		myBook.setDescription(book.getDescription());
		myBook.setPrice(book.getPrice());
		myBook.setLanguage(book.getLanguage());
		myBook.setNumberOfPages(book.getNumberOfPages());
		myBook.setPublished(book.getPublished());
		myBook.setPublisher(publisherRepository.findOneById(book.getPublisher().getId()));
		myBook.setCoverType(book.getCoverType());
		bookRepository.save(myBook);
		
		return myBook;
	}
	
	public Book findOneByBooksInBookstoreId(Long id) {
		return bookRepository.findOneByBooksInBookstores_Id(id);
	}
}
