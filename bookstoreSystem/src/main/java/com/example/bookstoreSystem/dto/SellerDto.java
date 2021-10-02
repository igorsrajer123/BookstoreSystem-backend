package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.Seller;

public class SellerDto {

	private Long id;
	private UserDto user;
	private BookstoreDto bookstore;
	
	public SellerDto() {
		super();
	}
	
	public SellerDto(Seller s) {
		this(s.getId(), new UserDto(s.getUser()), new BookstoreDto(s.getBookstore()));
	}
	
	public SellerDto(Long id, UserDto user, BookstoreDto bookstore) {
		super();
		this.setId(id);
		this.setUser(user);
		this.setBookstore(bookstore);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public BookstoreDto getBookstore() {
		return bookstore;
	}

	public void setBookstore(BookstoreDto bookstore) {
		this.bookstore = bookstore;
	}
}
