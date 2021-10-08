package com.example.bookstoreSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonManagedReference(value = "shoppingCart_movement")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Customer customer;
	
	@JsonManagedReference(value = "shoppingCartItems-movement")
	@OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private List<ShoppingCartItem> shoppingCartItems;
	
	public ShoppingCart() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}
}
