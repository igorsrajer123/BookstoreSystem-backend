package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.BookstoreAdministrator;

public class BookstoreAdministratorDto {

	private Long id;
	private UserDto user;
	private BookstoreDto bookstore;
	
	public BookstoreAdministratorDto() {
		super();
	}
	
	public BookstoreAdministratorDto(BookstoreAdministrator b) {
		this(b.getId(), new UserDto(b.getUser()), new BookstoreDto(b.getBookstore()));
	}
	
	public BookstoreAdministratorDto(Long id, UserDto user, BookstoreDto bookstore) {
		super();
		this.id = id;
		this.user = user;
		this.bookstore = bookstore;
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
