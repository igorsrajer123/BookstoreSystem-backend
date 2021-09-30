package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.ProductType;
import com.example.bookstoreSystem.repository.OtherProductRepository;

@Service
public class OtherProductService {

	@Autowired
	private OtherProductRepository otherProductRepository;
	
	public List<OtherProduct> findAll() {
		return otherProductRepository.findAll();
	}
	
	public OtherProduct findOneById(Long id) {
		return otherProductRepository.findOneById(id);
	}
	
	public OtherProduct findOneByName(String name) {
		return otherProductRepository.findOneByName(name);
	}
	
	public OtherProduct findOneByCode(String code) {
		return otherProductRepository.findOneByCode(code);
	}
	
	public List<OtherProduct> findAllByPublisherId(Long id) {
		return otherProductRepository.findAllByPublisherId(id);
	}
	
	public List<OtherProduct> findAllByType(ProductType type) {
		return otherProductRepository.findAllByType(type);
	}
}
