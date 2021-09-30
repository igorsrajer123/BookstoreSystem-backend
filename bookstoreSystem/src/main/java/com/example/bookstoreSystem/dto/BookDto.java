package com.example.bookstoreSystem.dto;

import java.time.LocalDate;

import com.example.bookstoreSystem.model.Book;
import com.example.bookstoreSystem.model.BookLanguage;

public class BookDto {

	private Long id;
	private String name;
	private String code;
	private String description;
	private double price;
	private LocalDate published;
	private String coverImage;
	private PublisherDto publisher;
	private int numberOfPages;
	private BookLanguage language;
	
	public BookDto() {
		super();
	}
	
	public BookDto(Book b) {
		this(b.getId(), b.getName(), b.getCode(), b.getDescription(), b.getPrice(), b.getPublished(), b.getCoverImage(), new PublisherDto(b.getPublisher()), b.getNumberOfPages(), b.getLanguage());
	}
	
	public BookDto(Long id, String name, String code, String description, double price, LocalDate published, String coverImage, PublisherDto publisher, int numberOfPages, BookLanguage language) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
		this.published = published;
		this.coverImage = coverImage;
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
		this.language = language;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublished() {
		return published;
	}

	public void setPublished(LocalDate published) {
		this.published = published;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public PublisherDto getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}
}
