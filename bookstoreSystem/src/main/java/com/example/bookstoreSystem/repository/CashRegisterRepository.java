package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.CashRegister;

@Repository
public interface CashRegisterRepository extends JpaRepository<CashRegister, Long>{

	List<CashRegister> findAll();
	
	CashRegister findOneById(Long id);
	
	CashRegister findOneByBookstoreId(Long id);
}
