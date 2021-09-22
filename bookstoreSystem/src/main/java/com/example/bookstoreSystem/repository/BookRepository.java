package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BookLanguage;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findAllByLanguage(BookLanguage language);
}
