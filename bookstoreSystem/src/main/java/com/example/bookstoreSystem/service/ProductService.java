package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Product;
import com.example.bookstoreSystem.model.ProductType;
import com.example.bookstoreSystem.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findOneById(Long id) {
		return productRepository.findOneById(id);
	}
	
	public Product findOneByName(String name) {
		return productRepository.findOneByName(name);
	}
	
	public Product findOneByCode(String code) {
		return productRepository.findOneByCode(code);
	}
	
	public List<Product> findAllByType(ProductType type) {
		return productRepository.findAllByType(type);
	}
}
