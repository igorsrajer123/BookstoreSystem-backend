package com.example.bookstoreSystem.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BooksBookstores;
import com.example.bookstoreSystem.model.Bookstore;
import com.example.bookstoreSystem.model.CashRegister;
import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.OtherProductsBookstores;
import com.example.bookstoreSystem.model.Receipt;
import com.example.bookstoreSystem.model.ReceiptItem;
import com.example.bookstoreSystem.model.ReceiptStatus;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.BooksBookstoresRepository;
import com.example.bookstoreSystem.repository.BookstoreRepository;
import com.example.bookstoreSystem.repository.CashRegisterRepository;
import com.example.bookstoreSystem.repository.OtherProductRepository;
import com.example.bookstoreSystem.repository.OtherProductsBookstoresRepository;
import com.example.bookstoreSystem.repository.ReceiptItemRepository;
import com.example.bookstoreSystem.repository.ReceiptRepository;
import com.example.bookstoreSystem.repository.SellerRepository;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private CashRegisterRepository cashRegisterRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private BookstoreRepository bookstoreRepository;
	
	@Autowired
	private ReceiptItemRepository receiptItemRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OtherProductRepository otherProductRepository;
	
	@Autowired
	private BooksBookstoresRepository bbRepository;
	
	@Autowired
	private OtherProductsBookstoresRepository opbRepository;
	
	public List<Receipt> findAll() {
		return receiptRepository.findAll();
	}
	
	public Receipt findOneById(Long id) {
		return receiptRepository.findOneById(id);
	}
	
	public List<Receipt> findAllByCashRegisterId(Long id) {
		return receiptRepository.findAllByCashRegisterId(id);
	}
	
	public Receipt createNew(Long sellerId, List<ReceiptItem> receiptItems) {
		Receipt newReceipt = new Receipt();
		newReceipt.setDateAndTime(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		newReceipt.setNumber(ThreadLocalRandom.current().nextInt(3000, 5000 + 1));
		newReceipt.setStatus(ReceiptStatus.CREATED);
		newReceipt.setSeller(sellerRepository.findOneById(sellerId));
		
		Bookstore myBookstore = bookstoreRepository.findOneByBookstoreSellers_Id(sellerId);
		CashRegister myCashRegister = cashRegisterRepository.findOneByBookstoreId(myBookstore.getId());
		newReceipt.setCashRegister(myCashRegister);
		
		List<ReceiptItem> items = new ArrayList<ReceiptItem>();
		items = generateReceiptItems(receiptItems, newReceipt);
		
		receiptRepository.save(newReceipt);
		items.forEach(i -> receiptItemRepository.save(i));
		
		updateBookstoreProductStock(items, myBookstore);
		newReceipt.setValue(generateReceiptFinalPrice(items));
		receiptRepository.save(newReceipt);
		return newReceipt;
	}
	
	private List<ReceiptItem> generateReceiptItems(List<ReceiptItem> requestItems, Receipt newReceipt) {
		List<ReceiptItem> items = new ArrayList<ReceiptItem>();
		
		for(ReceiptItem r : requestItems) {
			ReceiptItem newItem = new ReceiptItem();
			newItem.setAmount(r.getAmount());
			newItem.setReceipt(newReceipt);
			
			if(r.getBook() != null)
				newItem.setBook(bookRepository.findOneById( r.getBook().getId()));
			
			if(r.getOtherProduct() != null)
				newItem.setOtherProduct(otherProductRepository.findOneById(r.getOtherProduct().getId()));
			
			items.add(newItem);
		}
		
		return items;
	}
	
	private void updateBookstoreProductStock(List<ReceiptItem> items, Bookstore myBookstore) {
		List<BooksBookstores> booksFromBookstore = bbRepository.findAllByBookstoreId(myBookstore.getId());
		List<OtherProductsBookstores> otherProductsFromBookstore = opbRepository.findAllByBookstoreId(myBookstore.getId());
		
		for(ReceiptItem r : items) {
			if(r.getBook() != null)
				for(BooksBookstores bb : booksFromBookstore) 
					if(r.getBook().getId() == bb.getBook().getId()) {
						bb.setAmount(bb.getAmount() - r.getAmount());
						bbRepository.save(bb);
					}
		
			if(r.getOtherProduct() != null)
				for(OtherProductsBookstores opb : otherProductsFromBookstore) 
					if(r.getOtherProduct().getId() == opb.getOtherProduct().getId()) {
						opb.setAmount(opb.getAmount() - r.getAmount());
						opbRepository.save(opb);
					}		
		}	
		
	}
	
	private double generateReceiptFinalPrice(List<ReceiptItem> items) {
		double finalPrice = 0;
		
		for(ReceiptItem r : items) {
			if(r.getBook() != null) {
				Book book = bookRepository.findOneById(r.getBook().getId());
				finalPrice = finalPrice + r.getAmount() * book.getPrice();
			}
			
			if(r.getOtherProduct() != null) {
				OtherProduct otherProduct = otherProductRepository.findOneById(r.getOtherProduct().getId());
				finalPrice = finalPrice + r.getAmount() * otherProduct.getPrice();
			}
		}
		
		return finalPrice;
	}
	
	public Receipt reverseReceipt(Long id, Long bookstoreId) {
		Receipt myReceipt = receiptRepository.findOneById(id);
		myReceipt.setStatus(ReceiptStatus.REVERSED);
		receiptRepository.save(myReceipt);
		
		Bookstore myBookstore = bookstoreRepository.findOneById(bookstoreId);
		List<ReceiptItem> receiptItems = new ArrayList<ReceiptItem>();
		receiptItems = myReceipt.getReceiptItems();
		
		List<BooksBookstores> booksFromBookstore = bbRepository.findAllByBookstoreId(myBookstore.getId());
		List<OtherProductsBookstores> otherProductsFromBookstore = opbRepository.findAllByBookstoreId(myBookstore.getId());
		
		for(ReceiptItem r : receiptItems) {
			if(r.getBook() != null)
				for(BooksBookstores bb : booksFromBookstore) 
					if(r.getBook().getId() == bb.getBook().getId()) {
						bb.setAmount(bb.getAmount() + r.getAmount());
						bbRepository.save(bb);
					}
		
			if(r.getOtherProduct() != null)
				for(OtherProductsBookstores opb : otherProductsFromBookstore) 
					if(r.getOtherProduct().getId() == opb.getOtherProduct().getId()) {
						opb.setAmount(opb.getAmount() + r.getAmount());
						opbRepository.save(opb);
					}		
		}
		
		return myReceipt;
	}
}
