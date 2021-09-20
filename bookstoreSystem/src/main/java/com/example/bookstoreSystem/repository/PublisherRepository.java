package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{

	List<Publisher> findAll();
	
	Publisher findOneById();
}
