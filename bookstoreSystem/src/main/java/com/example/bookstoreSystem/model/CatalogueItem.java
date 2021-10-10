package com.example.bookstoreSystem.model;

import java.time.LocalDate;

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
public class CatalogueItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "priceStart", nullable = false)
	private LocalDate priceStart;
	
	@Column(name = "priceEnd", nullable = true)
	private LocalDate priceEnd;
	
	@Column(name = "price", nullable = true)
	private double price;
	
	@JsonBackReference(value = "catalogueItemBook-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private Book book;
	
	@JsonBackReference(value = "catalogueItemOtherProduct-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private OtherProduct otherProduct;

	public CatalogueItem() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPriceStart() {
		return priceStart;
	}

	public void setPriceStart(LocalDate priceStart) {
		this.priceStart = priceStart;
	}

	public LocalDate getPriceEnd() {
		return priceEnd;
	}

	public void setPriceEnd(LocalDate priceEnd) {
		this.priceEnd = priceEnd;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public OtherProduct getOtherProduct() {
		return otherProduct;
	}

	public void setOtherProduct(OtherProduct otherProduct) {
		this.otherProduct = otherProduct;
	}
}
