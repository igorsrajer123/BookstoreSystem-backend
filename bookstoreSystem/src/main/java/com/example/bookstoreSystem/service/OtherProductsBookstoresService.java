package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.OtherProductsBookstores;
import com.example.bookstoreSystem.repository.OtherProductsBookstoresRepository;

@Service
public class OtherProductsBookstoresService {

	@Autowired
	private OtherProductsBookstoresRepository otherProductsBookstoresRepository;
	
	public List<OtherProductsBookstores> findAll() {
		return otherProductsBookstoresRepository.findAll();
	}
	
	public List<OtherProductsBookstores> findAllByBookstoreId(Long id) {
		return otherProductsBookstoresRepository.findAllByBookstoreId(id);
	}
	
	public OtherProductsBookstores updateOtherProductsBookstoresAmount(OtherProductsBookstores otherProductsBookstores) {
		OtherProductsBookstores myOtherProduct = otherProductsBookstoresRepository.findOneById(otherProductsBookstores.getId());
		
		if(myOtherProduct == null) return null;
		
		myOtherProduct.setAmount(otherProductsBookstores.getAmount());
		otherProductsBookstoresRepository.save(myOtherProduct);
		
		return myOtherProduct;
	}
	
	public boolean checkOtherProductAmountAvailable(Long bookstoreId, Long otherProductId, int amount) {
		List<OtherProductsBookstores> bookstoreOtherProducts = otherProductsBookstoresRepository.findAllByBookstoreId(bookstoreId);
		for(OtherProductsBookstores o : bookstoreOtherProducts) {
			if(o.getOtherProduct().getId() == otherProductId) {
				if(o.getAmount() >= amount) {
					return true;
				}
			}
		}
		return false;
	}
}
