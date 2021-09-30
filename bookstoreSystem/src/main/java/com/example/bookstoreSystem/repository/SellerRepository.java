package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

	List<Seller> findAll();
	
	Seller findOneById(Long id);
	
	Seller findOneByUserId(Long id);
}
