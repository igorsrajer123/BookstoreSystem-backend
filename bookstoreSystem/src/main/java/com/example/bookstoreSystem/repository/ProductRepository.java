package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Product;
import com.example.bookstoreSystem.model.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findAll();
	
	Product findOneById(Long id);
	
	Product findOneByCode(int code);
	
	List<Product> findAllByType(ProductType type);
	
	List<Product> findAllByPublisherId(Long id);
}
