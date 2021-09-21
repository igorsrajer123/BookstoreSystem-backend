package com.example.bookstoreSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Book extends Product{

	@Column(name = "numberOfPages", nullable = true)
	private int numberOfPages;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "language", nullable = true)
	private BookLanguage language;
	
	public Book() {
		super();
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public BookLanguage getLanguage() {
		return language;
	}

	public void setLanguage(BookLanguage language) {
		this.language = language;
	}
}
