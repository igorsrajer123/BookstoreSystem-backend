package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.CashRegister;
import com.example.bookstoreSystem.repository.CashRegisterRepository;

@Service
public class CashRegisterService {

	@Autowired
	private CashRegisterRepository cashRegisterRepository;
	
	public List<CashRegister> findAll() {
		return cashRegisterRepository.findAll();
	}
	
	public CashRegister findOneById(Long id) {
		return cashRegisterRepository.findOneById(id);
	}
	
	public CashRegister findOneByBookstoreId(Long id) {
		return cashRegisterRepository.findOneByBookstoreId(id);
	}
}
