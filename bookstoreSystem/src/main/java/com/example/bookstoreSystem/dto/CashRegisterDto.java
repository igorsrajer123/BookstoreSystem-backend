package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.CashRegister;

public class CashRegisterDto {

	private Long id;
	private String code;
	private BookstoreDto bookstore;
	
	public CashRegisterDto() {
		super();
	}
	
	public CashRegisterDto(CashRegister c) {
		this(c.getId(), c.getCode(), new BookstoreDto(c.getBookstore()));
	}
	
	public CashRegisterDto(Long id, String code, BookstoreDto bookstore) {
		super();
		this.id = id;
		this.code = code;
		this.bookstore = bookstore;
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

	public BookstoreDto getBookstore() {
		return bookstore;
	}

	public void setBookstore(BookstoreDto bookstore) {
		this.bookstore = bookstore;
	}
}
