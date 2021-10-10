package com.example.bookstoreSystem.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.BooksBookstores;
import com.example.bookstoreSystem.model.Delivery;
import com.example.bookstoreSystem.model.DeliveryItem;
import com.example.bookstoreSystem.model.DeliveryStatus;
import com.example.bookstoreSystem.model.OtherProductsBookstores;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.BooksBookstoresRepository;
import com.example.bookstoreSystem.repository.CustomerRepository;
import com.example.bookstoreSystem.repository.DeliveryItemRepository;
import com.example.bookstoreSystem.repository.DeliveryRepository;
import com.example.bookstoreSystem.repository.OtherProductRepository;
import com.example.bookstoreSystem.repository.OtherProductsBookstoresRepository;

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
	
	@Autowired
	private BooksBookstoresRepository bbRepository;
	
	@Autowired
	private OtherProductsBookstoresRepository opbRepository;
	
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
		newDelivery.setCreatedDate(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		newDelivery.setDeliveryAddress(delivery.getDeliveryAddress());
		newDelivery.setStatus(DeliveryStatus.PENDING);
		newDelivery.setCustomer(customerRepository.findOneById(delivery.getCustomer().getId()));
		newDelivery.setNote(delivery.getNote());
		deliveryRepository.save(newDelivery);
		
		List<DeliveryItem> items = delivery.getDeliveryItems();
		double deliveryPrice = 0;
		for(DeliveryItem d : items) {
			DeliveryItem newItem = new DeliveryItem();
			if(d.getBook() == null) {
				newItem.setOtherProduct(otherProductRepository.findOneById(d.getOtherProduct().getId()));
				deliveryPrice += otherProductRepository.findOneById(d.getOtherProduct().getId()).getPrice() * d.getAmount();
			}
			
			if(d.getOtherProduct() == null) {
				newItem.setBook(bookRepository.findOneById(d.getBook().getId()));
				deliveryPrice += bookRepository.findOneById(d.getBook().getId()).getPrice() * d.getAmount();
			}
			
			newItem.setAmount(d.getAmount());
			newItem.setDelivery(newDelivery);
			deliveryItemRepository.save(newItem);
		}
		newDelivery.setPrice(deliveryPrice);
		deliveryRepository.save(newDelivery);
		
		return newDelivery;
	}
	
	private void removeFromStock(DeliveryItem item) {
		if(item.getBook() == null) {
			 List<OtherProductsBookstores> otherProducts = opbRepository.findAllByOtherProductId(item.getOtherProduct().getId());
				 for(int i = 0; i < otherProducts.size(); i++) {
					 if(otherProducts.get(i).getAmount() - item.getAmount() >= 0) {
						 otherProducts.get(i).setAmount(otherProducts.get(i).getAmount() - item.getAmount());
						 opbRepository.save(otherProducts.get(i));
						 item.setAmount(0);
					 }else {
						 otherProducts.get(i).setAmount(0);
						 opbRepository.save(otherProducts.get(i));
						 item.setAmount(item.getAmount() - otherProducts.get(i).getAmount());
					 }
				 }
		}
		
		if(item.getOtherProduct() == null) {
			List<BooksBookstores> books = bbRepository.findAllByBookId(item.getBook().getId());
				for(int i = 0; i < books.size(); i++) {
					if(books.get(i).getAmount() - item.getAmount() >= 0) {
						books.get(i).setAmount(books.get(i).getAmount() - item.getAmount());
						bbRepository.save(books.get(i));
						item.setAmount(0);
					}else {
						books.get(i).setAmount(0);
						bbRepository.save(books.get(i));
						item.setAmount(item.getAmount() - books.get(i).getAmount());
					}
				}
		}
	}
	
	public Delivery declineDelivery(Long id) {
		Delivery myDelivery = deliveryRepository.findOneById(id);
		myDelivery.setStatus(DeliveryStatus.DECLINED);
		deliveryRepository.save(myDelivery);
		
		return myDelivery;
	}
	
	public Delivery acceptDelivery(Long id){
		Delivery myDelivery = deliveryRepository.findOneById(id);
		myDelivery.getDeliveryItems().forEach(i -> removeFromStock(i));
		myDelivery.setStatus(DeliveryStatus.ACCEPTED);
		deliveryRepository.save(myDelivery);
		
		return myDelivery;
	}
}
