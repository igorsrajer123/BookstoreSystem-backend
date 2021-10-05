package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Bookstore;
import com.example.bookstoreSystem.repository.BookstoreRepository;

@Service
public class BookstoreService {

	@Autowired
	private BookstoreRepository bookstoreRepository;
	
	public List<Bookstore> findAll() {
		return bookstoreRepository.findAll();
	}
	
	public Bookstore findOneById(Long id) {
		return bookstoreRepository.findOneById(id);
	}
	
	public Bookstore findOneByBookstoreAdministratorId(Long id) {
		return bookstoreRepository.findOneByBookstoreAdministrators_Id(id);
	}
	
	public Bookstore findOneBySellerId(Long id) {
		return bookstoreRepository.findOneByBookstoreSellers_Id(id);
	}
	
	public Bookstore save(Bookstore bookstore) {
		return bookstoreRepository.save(bookstore);
	}
	
	public Bookstore updateBookstore(Bookstore bookstore) {
		Bookstore myBookstore = bookstoreRepository.findOneById(bookstore.getId());
		
		if(myBookstore == null) return null;
		
		myBookstore.setName(bookstore.getName());
		myBookstore.setAddress(bookstore.getAddress());
		myBookstore.setCity(bookstore.getCity());
		myBookstore.setContactPhone(bookstore.getContactPhone());
		bookstoreRepository.save(myBookstore);
		
		return myBookstore;
	}
	
	public Bookstore createNew(Bookstore bookstore) {
		Bookstore newBookstore = new Bookstore();
		newBookstore.setName(bookstore.getName());
		newBookstore.setAddress(bookstore.getAddress());
		newBookstore.setCity(bookstore.getCity());
		newBookstore.setContactPhone(bookstore.getContactPhone());
		newBookstore.setNumberOfVotes(0);
		newBookstore.setRating(0.0);
		bookstoreRepository.save(newBookstore);
		
		return newBookstore;
	}
}
