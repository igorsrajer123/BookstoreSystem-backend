package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.ReceiptItem;

public class ReceiptItemDto {

	private Long id;
	private int amount;
	private ReceiptDto receipt;
	private BookDto book;
	private OtherProductDto otherProduct;
	
	public ReceiptItemDto() {
		super();
	}
	
	public ReceiptItemDto(ReceiptItem r) {
		this(r.getId(), r.getAmount(), new ReceiptDto(r.getReceipt()), new BookDto(r.getBook()), new OtherProductDto(r.getOtherProduct()));
	}
	
	public ReceiptItemDto(Long id, int amount, ReceiptDto receipt, BookDto book, OtherProductDto otherProduct) {
		super();
		this.id = id;
		this.amount = amount;
		this.receipt = receipt;
		this.book = book;
		this.otherProduct = otherProduct;
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


	public ReceiptDto getReceipt() {
		return receipt;
	}


	public void setReceipt(ReceiptDto receipt) {
		this.receipt = receipt;
	}


	public BookDto getBook() {
		return book;
	}


	public void setBook(BookDto book) {
		this.book = book;
	}


	public OtherProductDto getOtherProduct() {
		return otherProduct;
	}


	public void setOtherProduct(OtherProductDto otherProduct) {
		this.otherProduct = otherProduct;
	}
}
