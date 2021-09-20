package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.BookstoreAdministrator;

@Repository
public interface BookstoreAdministratorRepository extends JpaRepository<BookstoreAdministrator, Long>{

	List<BookstoreAdministrator> findAll();
	
	BookstoreAdministrator findOneById(Long id);
	
	BookstoreAdministrator findOneByUserId(Long id);
}
