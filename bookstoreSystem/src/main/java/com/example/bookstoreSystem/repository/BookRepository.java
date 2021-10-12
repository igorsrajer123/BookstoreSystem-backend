package com.example.bookstoreSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BookLanguage;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findAll();
	
	Book findOneById(Long id);
	
	Book findOneByName(String name);
	
	Book findOneByCode(String code);
	
	List<Book> findAllByLanguage(BookLanguage language);
	
	List<Book> findAllByGenres_Name(String name);
	
	List<Book> findAllByPublisherId(Long id);
	
	Book findOneByBooksInBookstores_Id(Long id);
	
	Book findOneByBookReceiptItems_Id(Long id);
	
	Book findOneByShoppingCartItems_Id(Long id);
	
	Book findOneByDeliveryItems_Id(Long id);
	
	List<Book> findAllByNameContainingIgnoreCase(String name);
}
