package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Bookstore;

@Repository
public interface BookstoreRepository extends JpaRepository<Bookstore, Long>{

	List<Bookstore> findAll();
	
	Bookstore findOneById(Long id);
}
