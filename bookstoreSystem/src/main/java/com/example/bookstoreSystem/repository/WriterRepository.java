package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Writer;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long>{
	
	List<Writer> findAll();
	
	Writer findOneById(Long id);
}
