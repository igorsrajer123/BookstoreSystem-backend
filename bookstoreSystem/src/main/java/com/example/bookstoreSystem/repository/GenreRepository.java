package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bookstoreSystem.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

	List<Genre> findAll();
	
	Genre findOneById(Long id);
	
	Genre findOneByName(String name);
}
