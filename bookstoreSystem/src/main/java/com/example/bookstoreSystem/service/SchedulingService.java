package com.example.bookstoreSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.bookstoreSystem.repository.ShoppingCartItemRepository;

@Component
public class SchedulingService {


	@Autowired
	private ShoppingCartItemRepository shopingCartItemRepository;
	
	@Async
	@Scheduled(cron = "0 0 0 * * *")
	private void emptyShoppingCart() {
		shopingCartItemRepository.findAll().forEach(i -> shopingCartItemRepository.deleteAll());
	}
}
