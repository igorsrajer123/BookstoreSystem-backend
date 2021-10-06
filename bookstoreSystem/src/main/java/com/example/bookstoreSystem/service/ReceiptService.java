package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Receipt;
import com.example.bookstoreSystem.repository.ReceiptRepository;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository;
	
	public List<Receipt> findAll() {
		return receiptRepository.findAll();
	}
	
	public Receipt findOneById(Long id) {
		return receiptRepository.findOneById(id);
	}
	
	public List<Receipt> findAllByCashRegisterId(Long id) {
		return receiptRepository.findAllByCashRegisterId(id);
	}
}
