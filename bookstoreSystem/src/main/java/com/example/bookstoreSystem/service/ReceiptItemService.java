package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.ReceiptItem;
import com.example.bookstoreSystem.repository.ReceiptItemRepository;

@Service
public class ReceiptItemService {

	@Autowired
	private ReceiptItemRepository receiptItemRepository;
	
	public List<ReceiptItem> findAll() {
		return receiptItemRepository.findAll();
	}
	
	public List<ReceiptItem> findAllByReceiptId(Long id){
		return receiptItemRepository.findAllByReceiptId(id);
	}
}
