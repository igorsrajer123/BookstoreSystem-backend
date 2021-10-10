package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.CatalogueItem;
import com.example.bookstoreSystem.repository.CatalogueItemRepository;

@Service
public class CatalogueItemService {

	@Autowired
	private CatalogueItemRepository catalogueItemRepository;
	
	public List<CatalogueItem> findAllByBookId(Long id) {
		return catalogueItemRepository.findAllByBookId(id);
	}
	
	public List<CatalogueItem> findAllByOtherProductId(Long id) {
		return catalogueItemRepository.findAllByOtherProductId(id);
	}
}
