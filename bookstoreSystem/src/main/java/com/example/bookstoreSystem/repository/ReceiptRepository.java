package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long>{

	List<Receipt> findAll();
	
	Receipt findOneById(Long id);
	
	List<Receipt> findAllByCashRegisterId(Long id);
}
