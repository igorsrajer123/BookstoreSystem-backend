package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.CatalogueItem;

@Repository
public interface CatalogueItemRepository extends JpaRepository<CatalogueItem, Long>{

	List<CatalogueItem> findAllByBookId(Long id);
	
	List<CatalogueItem> findAllByOtherProductId(Long id);
}
