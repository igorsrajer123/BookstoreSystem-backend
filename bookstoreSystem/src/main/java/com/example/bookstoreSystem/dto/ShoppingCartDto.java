package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.ShoppingCart;

public class ShoppingCartDto {

	private Long id;
	private CustomerDto customer;
	
	public ShoppingCartDto() {
		super();
	}

	public ShoppingCartDto(ShoppingCart s) {
		this(s.getId(), new CustomerDto(s.getCustomer()));
	}
	
	public ShoppingCartDto(Long id, CustomerDto customer) {
		super();
		this.id = id;
		this.customer = customer;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
}
