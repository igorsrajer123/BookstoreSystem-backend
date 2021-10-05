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
public class OtherProductsBookstores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "amount")
	private int amount;

	@JsonBackReference(value = "bookstoreOtherProducts-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Bookstore bookstore;
	
	@JsonBackReference(value = "otherProductBookstores-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private OtherProduct otherProduct;

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

	public OtherProduct getOtherProduct() {
		return otherProduct;
	}

	public void setOtherProduct(OtherProduct otherProduct) {
		this.otherProduct = otherProduct;
	}
}
