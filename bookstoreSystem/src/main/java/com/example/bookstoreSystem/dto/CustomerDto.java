package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.Customer;

public class CustomerDto {

	private Long id;
	private boolean processed;
	private UserDto user;
	
	public CustomerDto() {
		super();
	}
	
	public CustomerDto(Customer c) {
		this(c.getId(), c.isProcessed(), new UserDto(c.getUser()));
	}
	
	public CustomerDto(Long id, boolean processed, UserDto user) {
		super();
		this.id = id;
		this.processed = processed;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
}
