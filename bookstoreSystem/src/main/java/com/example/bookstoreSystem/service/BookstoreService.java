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
}
