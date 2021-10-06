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
public class ReceiptItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "amount", nullable = false)
	private int amount;
	
	@JsonBackReference(value = "receiptReceiptItem-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Receipt receipt;
	
	@JsonBackReference(value = "bookReceiptItem-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Book book;
	
	@JsonBackReference(value = "otherProductReceiptItem-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private OtherProduct otherProduct;
	
	public ReceiptItem() {
		super();
	}

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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
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
