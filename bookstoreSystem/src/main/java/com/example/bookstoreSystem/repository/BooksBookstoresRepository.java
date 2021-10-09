package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.BooksBookstores;

@Repository
public interface BooksBookstoresRepository extends JpaRepository<BooksBookstores, Long>{

	List<BooksBookstores> findAll();
	
	BooksBookstores findOneById(Long id);
	
	List<BooksBookstores> findAllByBookstoreId(Long id);
	
	List<BooksBookstores> findAllByBookId(Long id);
}
