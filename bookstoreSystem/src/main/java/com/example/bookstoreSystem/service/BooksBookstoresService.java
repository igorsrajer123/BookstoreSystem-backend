package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.BooksBookstores;
import com.example.bookstoreSystem.repository.BooksBookstoresRepository;

@Service
public class BooksBookstoresService {

	@Autowired
	private BooksBookstoresRepository booksBookstoresRepository;
	
	public List<BooksBookstores> findAll() {
		return booksBookstoresRepository.findAll();
	}
	
	public List<BooksBookstores> findAllByBookstoreId(Long id) {
		return booksBookstoresRepository.findAllByBookstoreId(id);
	}
	
	public BooksBookstores updateBooksBookstoresAmount(BooksBookstores booksBookstores) {
		BooksBookstores myBook = booksBookstoresRepository.findOneById(booksBookstores.getId());
		
		if(myBook == null) return null;
		
		myBook.setAmount(booksBookstores.getAmount());
		booksBookstoresRepository.save(myBook);
		
		return myBook;
	}
	
	public boolean checkBookAmountAvailable(Long bookstoreId, Long bookId, int amount) {
		List<BooksBookstores> bookstoreBooks = booksBookstoresRepository.findAllByBookstoreId(bookstoreId);
		for(BooksBookstores b : bookstoreBooks) {
			if(b.getBook().getId() == bookId) {
				if(b.getAmount() >= amount) {
					return true;
				}
			}
		}
		return false;
	}
}
