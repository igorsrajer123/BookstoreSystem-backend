package com.example.bookstoreSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.ShoppingCart;
import com.example.bookstoreSystem.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCart findOneByCustomerId(Long id) {
		return shoppingCartRepository.findOneByCustomerId(id);
	}
}
