package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.BookstoreSystemAdministrator;

@Repository
public interface BookstoreSystemAdministratorRepository extends JpaRepository<BookstoreSystemAdministrator, Long>{

	List<BookstoreSystemAdministrator> findAll();
	
	BookstoreSystemAdministrator findOneById(Long id);
	
	BookstoreSystemAdministrator findOneByUserId(Long id);
}
