package com.example.bookstoreSystem.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BooksBookstores;
import com.example.bookstoreSystem.model.Bookstore;
import com.example.bookstoreSystem.model.CashRegister;
import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.OtherProductsBookstores;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.BooksBookstoresRepository;
import com.example.bookstoreSystem.repository.BookstoreRepository;
import com.example.bookstoreSystem.repository.CashRegisterRepository;
import com.example.bookstoreSystem.repository.OtherProductRepository;
import com.example.bookstoreSystem.repository.OtherProductsBookstoresRepository;

@Service
public class BookstoreService {

	@Autowired
	private BookstoreRepository bookstoreRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OtherProductRepository otherProductRepository;
	
	@Autowired
	private BooksBookstoresRepository bbRepository;
	
	@Autowired
	private OtherProductsBookstoresRepository opbRepository;
	
	@Autowired
	private CashRegisterRepository cashRegisterRepository;
	
	public List<Bookstore> findAll() {
		return bookstoreRepository.findAll();
	}
	
	public Bookstore findOneById(Long id) {
		return bookstoreRepository.findOneById(id);
	}
	
	public Bookstore findOneByBookstoreAdministratorId(Long id) {
		return bookstoreRepository.findOneByBookstoreAdministrators_Id(id);
	}
	
	public Bookstore findOneBySellerId(Long id) {
		return bookstoreRepository.findOneByBookstoreSellers_Id(id);
	}
	
	public Bookstore save(Bookstore bookstore) {
		return bookstoreRepository.save(bookstore);
	}
	
	public Bookstore updateBookstore(Bookstore bookstore) {
		Bookstore myBookstore = bookstoreRepository.findOneById(bookstore.getId());
		
		if(myBookstore == null) return null;
		
		myBookstore.setName(bookstore.getName());
		myBookstore.setAddress(bookstore.getAddress());
		myBookstore.setCity(bookstore.getCity());
		myBookstore.setContactPhone(bookstore.getContactPhone());
		bookstoreRepository.save(myBookstore);
		
		return myBookstore;
	}
	
	public Bookstore createNew(Bookstore bookstore) {
		String uuid = UUID.randomUUID().toString().replace("-", "").replace("0", "").substring(1, 10);
		
		CashRegister newCashRegister = new CashRegister();
		newCashRegister.setCode(uuid);
		cashRegisterRepository.save(newCashRegister);
		
		Bookstore newBookstore = new Bookstore();
		newBookstore.setName(bookstore.getName());
		newBookstore.setAddress(bookstore.getAddress());
		newBookstore.setCity(bookstore.getCity());
		newBookstore.setContactPhone(bookstore.getContactPhone());
		newBookstore.setNumberOfVotes(0);
		newBookstore.setRating(0.0);
		newBookstore.setCashRegister(newCashRegister);
		bookstoreRepository.save(newBookstore);
		
		List<Book> allBooks = bookRepository.findAll();
		for(Book b : allBooks) {
			BooksBookstores newBookBookstore = new BooksBookstores();
			newBookBookstore.setAmount(0);
			newBookBookstore.setBook(b);
			newBookBookstore.setBookstore(newBookstore);
			bbRepository.save(newBookBookstore);
		}
		
		List<OtherProduct> allOtherProducts = otherProductRepository.findAll();
		for(OtherProduct o : allOtherProducts) {
			OtherProductsBookstores newOtherProductBookstore = new OtherProductsBookstores();
			newOtherProductBookstore.setAmount(0);
			newOtherProductBookstore.setOtherProduct(o);
			newOtherProductBookstore.setBookstore(newBookstore);
			opbRepository.save(newOtherProductBookstore);
		}
		
		return newBookstore;
	}
	
	public List<Bookstore> findAllByNameContaining(String str) {
		return bookstoreRepository.findAllByNameContainingIgnoreCase(str);
	}
}
