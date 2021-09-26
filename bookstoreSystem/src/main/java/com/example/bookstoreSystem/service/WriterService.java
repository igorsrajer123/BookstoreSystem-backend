package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Writer;
import com.example.bookstoreSystem.repository.WriterRepository;

@Service
public class WriterService {

	@Autowired
	private WriterRepository writerRepository;
	
	public List<Writer> findAll() {
		return writerRepository.findAll();
	}
	
	public Writer findOneById(Long id) {
		return writerRepository.findOneById(id);
	}
	
	public Writer findOneByName(String name) {
		return writerRepository.findOneByName(name);
	}
	
	public List<Writer> findAllByBookName(String name) {
		return writerRepository.findAllByBooks_Name(name);
	}
}
