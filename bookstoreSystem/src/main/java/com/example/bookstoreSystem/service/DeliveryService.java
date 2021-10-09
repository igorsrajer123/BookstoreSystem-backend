package com.example.bookstoreSystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Delivery;
import com.example.bookstoreSystem.model.DeliveryItem;
import com.example.bookstoreSystem.model.DeliveryStatus;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.CustomerRepository;
import com.example.bookstoreSystem.repository.DeliveryItemRepository;
import com.example.bookstoreSystem.repository.DeliveryRepository;
import com.example.bookstoreSystem.repository.OtherProductRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired 
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OtherProductRepository otherProductRepository;
	
	@Autowired
	private DeliveryItemRepository deliveryItemRepository;
	
	public List<Delivery> findAll() {
		return deliveryRepository.findAll();
	}
	
	public Delivery findOneById(Long id) {
		return deliveryRepository.findOneById(id);
	}
	
	public Delivery createNew(Delivery delivery) {
		Delivery newDelivery = new Delivery();
		newDelivery.setContactPhone(delivery.getContactPhone());
		newDelivery.setPostalCode(delivery.getPostalCode());
		newDelivery.setCreatedDate(LocalDateTime.now());
		newDelivery.setDeliveryAddress(delivery.getDeliveryAddress());
		newDelivery.setStatus(DeliveryStatus.PENDING);
		newDelivery.setCustomer(customerRepository.findOneById(delivery.getCustomer().getId()));
		newDelivery.setNote(delivery.getNote());
		deliveryRepository.save(newDelivery);
		
		List<DeliveryItem> items = delivery.getDeliveryItems();
		for(DeliveryItem d : items) {
			DeliveryItem newItem = new DeliveryItem();
			if(d.getBook() == null)
				newItem.setOtherProduct(otherProductRepository.findOneById(d.getOtherProduct().getId()));
			
			if(d.getOtherProduct() == null)
				newItem.setBook(bookRepository.findOneById(d.getBook().getId()));
			
			newItem.setAmount(d.getAmount());
			newItem.setDelivery(newDelivery);
			deliveryItemRepository.save(newItem);
		}
		
		return newDelivery;
	}
	
	public Delivery declineDelivery(Long id) {
		Delivery myDelivery = deliveryRepository.findOneById(id);
		myDelivery.setStatus(DeliveryStatus.DECLINED);
		deliveryRepository.save(myDelivery);
		
		return myDelivery;
	}
	
	public Delivery acceptDelivery(Long id){
		Delivery myDelivery = deliveryRepository.findOneById(id);
		myDelivery.setStatus(DeliveryStatus.ACCEPTED);
		deliveryRepository.save(myDelivery);
		
		return myDelivery;
	}
}
