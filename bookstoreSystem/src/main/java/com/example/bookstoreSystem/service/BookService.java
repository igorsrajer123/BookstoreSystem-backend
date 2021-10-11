package com.example.bookstoreSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BookLanguage;
import com.example.bookstoreSystem.model.BooksBookstores;
import com.example.bookstoreSystem.model.Bookstore;
import com.example.bookstoreSystem.model.CatalogueItem;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.BooksBookstoresRepository;
import com.example.bookstoreSystem.repository.BookstoreRepository;
import com.example.bookstoreSystem.repository.CatalogueItemRepository;
import com.example.bookstoreSystem.repository.PublisherRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Autowired
	private BooksBookstoresRepository booksBookstoresRepository;
	
	@Autowired
	private BookstoreRepository bookstoreRepository;
	
	@Autowired
	private CatalogueItemRepository catalogueItemRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Book findOneById(Long id) {
		return bookRepository.findOneById(id);
	}
	
	public Book findOneByName(String name) {
		return bookRepository.findOneByName(name);
	}
	
	public Book findOneByCode(String code) {
		return bookRepository.findOneByCode(code);
	}
	
	public List<Book> findAllByPublisherId(Long id) {
		return bookRepository.findAllByPublisherId(id);
	}
	
	public List<Book> findAllByLanguage(BookLanguage language) {
		return bookRepository.findAllByLanguage(language);
	}
	
	public List<Book> findAllByGenreName(String name) {
		return bookRepository.findAllByGenres_Name(name);
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public Book createNew(Book book) {
		Book newBook = new Book();
		newBook.setCode(book.getCode());
		newBook.setName(book.getName());
		newBook.setNumberOfPages(book.getNumberOfPages());
		newBook.setPrice(book.getPrice());
		newBook.setPublished(book.getPublished());
		newBook.setPublisher(publisherRepository.findOneById(book.getPublisher().getId()));
		newBook.setLanguage(book.getLanguage());
		newBook.setCoverType(book.getCoverType());
		newBook.setDescription(book.getDescription());
		newBook.setGenres(book.getGenres());
		bookRepository.save(newBook);
		
		List<Bookstore> allBookstores = bookstoreRepository.findAll();
		for(Bookstore b : allBookstores) {
			BooksBookstores newBookBookstore = new BooksBookstores();
			newBookBookstore.setAmount(0);
			newBookBookstore.setBookstore(b);
			newBookBookstore.setBook(newBook);
			booksBookstoresRepository.save(newBookBookstore);
		}
		
		CatalogueItem newCatalogueItem = new CatalogueItem();
		newCatalogueItem.setOtherProduct(null);
		newCatalogueItem.setPriceEnd(null);
		newCatalogueItem.setBook(newBook);
		newCatalogueItem.setPrice(newBook.getPrice());
		newCatalogueItem.setPriceStart(LocalDate.now());
		catalogueItemRepository.save(newCatalogueItem);
		
		return newBook;
	}
	
	public Book updateBook(Book book) {
		Book myBook = bookRepository.findOneById(book.getId());
		
		if(myBook == null) return null;
		
		double price = myBook.getPrice();
		myBook.setName(book.getName());
		myBook.setDescription(book.getDescription());
		myBook.setPrice(book.getPrice());
		myBook.setLanguage(book.getLanguage());
		myBook.setNumberOfPages(book.getNumberOfPages());
		myBook.setPublished(book.getPublished());
		myBook.setPublisher(publisherRepository.findOneById(book.getPublisher().getId()));
		myBook.setCoverType(book.getCoverType());
		
		List<CatalogueItem> bookItems = catalogueItemRepository.findAllByBookId(myBook.getId());
		for(CatalogueItem c : bookItems) 
			if(c.getPriceEnd() == null) {
				if(c.getPrice() != myBook.getPrice()) {
					c.setPriceEnd(LocalDate.now());
					catalogueItemRepository.save(c);
					break;
				}
			}
			
		if(price != book.getPrice()) {
			CatalogueItem newCatalogueItem = new CatalogueItem();
			newCatalogueItem.setOtherProduct(null);
			newCatalogueItem.setPriceEnd(null);
			newCatalogueItem.setBook(myBook);
			newCatalogueItem.setPrice(myBook.getPrice());
			newCatalogueItem.setPriceStart(LocalDate.now());
			catalogueItemRepository.save(newCatalogueItem);
		}
		
		bookRepository.save(myBook);
		
		return myBook;
	}
	
	public Book findOneByBooksInBookstoreId(Long id) {
		return bookRepository.findOneByBooksInBookstores_Id(id);
	}
	
	public Book findOneByReceiptItemId(Long id) {
		return bookRepository.findOneByBookReceiptItems_Id(id);
	}
	
	public Book findOneByShoppingCartItem(Long id) {
		return bookRepository.findOneByShoppingCartItems_Id(id);
	}
	
	public Book findOneByDeliveryItem(Long id) {
		return bookRepository.findOneByDeliveryItems_Id(id);
	}
	
	public double updatePrice(Long id, double price) {
		Book myBook = bookRepository.findOneById(id);
		double oldPrice = myBook.getPrice();
		
		myBook.setPrice(price);
		bookRepository.save(myBook);
		
		List<CatalogueItem> bookItems = catalogueItemRepository.findAllByBookId(myBook.getId());
		for(CatalogueItem c : bookItems) 
			if(c.getPriceEnd() == null) {
				if(c.getPrice() != price) {
					c.setPriceEnd(LocalDate.now());
					catalogueItemRepository.save(c);
					break;
				}
			}
		
		if(oldPrice != price) {
			CatalogueItem newItem = new CatalogueItem();
			newItem.setBook(myBook);
			newItem.setOtherProduct(null);
			newItem.setPriceEnd(null);
			newItem.setPrice(price);
			newItem.setPriceStart(LocalDate.now());
			catalogueItemRepository.save(newItem);
		}
		
		return price;
	}
}
