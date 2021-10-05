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
	
	public Publisher createNew(Publisher publisher) {
		Publisher newPublisher = new Publisher();
		newPublisher.setName(publisher.getName());
		newPublisher.setAddress(publisher.getAddress());
		newPublisher.setCity(publisher.getCity());
		newPublisher.setPhoneNumber(publisher.getPhoneNumber());
		publisherRepository.save(newPublisher);
		
		return newPublisher;
	}
	
	public Publisher editPublisher(Publisher publisher) {
		Publisher myPublisher = publisherRepository.findOneById(publisher.getId());
		myPublisher.setName(publisher.getName());
		myPublisher.setAddress(publisher.getAddress());
		myPublisher.setCity(publisher.getCity());
		myPublisher.setPhoneNumber(publisher.getPhoneNumber());
		publisherRepository.save(myPublisher);
		
		return myPublisher;
	}
}
