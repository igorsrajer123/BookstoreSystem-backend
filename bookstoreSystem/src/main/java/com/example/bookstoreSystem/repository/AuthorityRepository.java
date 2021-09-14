package com.example.bookstoreSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

	Authority findOneById(Long id);
	
	Authority findOneByName(String name);
}
