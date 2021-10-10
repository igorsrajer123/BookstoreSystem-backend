package com.example.bookstoreSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.DeliveryItem;
import com.example.bookstoreSystem.repository.DeliveryItemRepository;

@Service
public class DeliveryItemService {

	@Autowired
	private DeliveryItemRepository deliveryItemRepository;
	
	public List<DeliveryItem> findallByDeliveryId(Long id) {
		return deliveryItemRepository.findAllByDeliveryId(id);
	}
}
