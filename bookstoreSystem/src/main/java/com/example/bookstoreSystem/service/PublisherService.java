package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Publisher;
import com.example.bookstoreSystem.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	public List<Publisher> findAll() {
		return publisherRepository.findAll();
	}
	
	public Publisher findOneById(Long id) {
		return publisherRepository.findOneById(id);
	}
}
