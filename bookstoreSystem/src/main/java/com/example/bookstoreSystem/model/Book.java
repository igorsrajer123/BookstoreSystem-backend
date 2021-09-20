package com.example.bookstoreSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends Product{

	@Column(name = "numberOfPages", nullable = true)
	private int numberOfPages;
	
	@Column(name = "language", nullable = true)
	private String language;
	
	public Book() {
		super();
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
