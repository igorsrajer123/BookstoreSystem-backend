package com.example.bookstoreSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.Writer;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.WriterRepository;

@Service
public class WriterService {

	@Autowired
	private WriterRepository writerRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
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
	
	public Writer save(Writer writer) {
		return writerRepository.save(writer);
	}
	
	public Writer updateWriter(Writer writer) {
		Writer myWriter = writerRepository.findOneById(writer.getId());
		
		if(myWriter == null) return null;
		
		myWriter.setName(writer.getName());
		myWriter.setDescription(writer.getDescription());
		writerRepository.save(myWriter);
		
		return myWriter;
	}
	
	public Writer createNew(Writer writer) {
		Writer newWriter = new Writer();
		newWriter.setName(writer.getName());
		newWriter.setDescription(writer.getDescription());
		writerRepository.save(newWriter);
		
		return newWriter;
	}
	
	public void addWriterNewBook(String bookCode, List<Writer> writers) {
		Book myBook = bookRepository.findOneByCode(bookCode);
		
		List<Writer> myWriters = new ArrayList<Writer>();
		writers.forEach(w -> myWriters.add(writerRepository.findOneById(w.getId())));
		
		myWriters.forEach(w -> {
			w.getBooks().add(myBook);
			writerRepository.save(w);
		});
	}
}
