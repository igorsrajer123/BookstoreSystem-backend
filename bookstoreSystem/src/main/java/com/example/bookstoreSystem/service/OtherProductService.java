package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.ProductType;
import com.example.bookstoreSystem.repository.OtherProductRepository;
import com.example.bookstoreSystem.repository.PublisherRepository;

@Service
public class OtherProductService {

	@Autowired
	private OtherProductRepository otherProductRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
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
	
	public OtherProduct save(OtherProduct otherProduct) {
		return otherProductRepository.save(otherProduct);
	}
	
	public OtherProduct createNew(OtherProduct otherProduct) {
		OtherProduct newOtherProduct = new OtherProduct();
		newOtherProduct.setCode(otherProduct.getCode());
		newOtherProduct.setName(otherProduct.getName());
		newOtherProduct.setPrice(otherProduct.getPrice());
		newOtherProduct.setPublished(otherProduct.getPublished());
		newOtherProduct.setPublisher(publisherRepository.findOneById(otherProduct.getPublisher().getId()));
		newOtherProduct.setDescription(otherProduct.getDescription());
		newOtherProduct.setExpirationDate(otherProduct.getExpirationDate());
		newOtherProduct.setType(otherProduct.getType());
		otherProductRepository.save(newOtherProduct);
		
		return newOtherProduct;
	}
	
	public OtherProduct updateOtherProduct(OtherProduct otherProduct) {
		OtherProduct myOtherProduct = otherProductRepository.findOneById(otherProduct.getId());
		
		if(myOtherProduct == null) return null;
		
		myOtherProduct.setName(otherProduct.getName());
		myOtherProduct.setDescription(otherProduct.getDescription());
		myOtherProduct.setPrice(otherProduct.getPrice());
		myOtherProduct.setPublished(otherProduct.getPublished());
		myOtherProduct.setPublisher(publisherRepository.findOneById(otherProduct.getPublisher().getId()));
		otherProductRepository.save(myOtherProduct);
		
		return myOtherProduct; 
	}
	
	public OtherProduct findOneByOtherProductsBookstoresId(Long id) {
		return otherProductRepository.findOneByOtherProductsInBookstores_Id(id);
	}
}
