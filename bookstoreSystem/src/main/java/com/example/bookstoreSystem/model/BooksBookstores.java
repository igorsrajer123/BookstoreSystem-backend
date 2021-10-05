package com.example.bookstoreSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BooksBookstores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "amount")
	private int amount;

	@JsonBackReference(value = "bookstoreBooks-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Bookstore bookstore;
	
	@JsonBackReference(value = "bookBookstores-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Bookstore getBookstore() {
		return bookstore;
	}

	public void setBookstore(Bookstore bookstore) {
		this.bookstore = bookstore;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}


