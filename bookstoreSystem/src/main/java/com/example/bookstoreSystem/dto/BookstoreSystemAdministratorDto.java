package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.BookstoreSystemAdministrator;

public class BookstoreSystemAdministratorDto {

	private Long id;
	private UserDto user;
	
	public BookstoreSystemAdministratorDto() {
		super();
	}
	
	public BookstoreSystemAdministratorDto(BookstoreSystemAdministrator b) {
		this(b.getId(), new UserDto(b.getUser()));
	}
	
	public BookstoreSystemAdministratorDto(Long id, UserDto user) {
		super();
		this.id = id;
		this.user = user;
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
}
