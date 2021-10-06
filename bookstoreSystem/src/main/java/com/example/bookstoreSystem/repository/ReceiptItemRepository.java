package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.ReceiptItem;

@Repository
public interface ReceiptItemRepository extends JpaRepository<ReceiptItem, Long>{

	List<ReceiptItem> findAll();
	
	List<ReceiptItem> findAllByReceiptId(Long id);
}
