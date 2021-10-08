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
public class ShoppingCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "amount", nullable = true)
	private int amount;
	
	@JsonBackReference(value = "shoppingCartItems-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private ShoppingCart shoppingCart;
	
	@JsonBackReference(value = "shoppingCartItemsBook-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private Book book;
	
	@JsonBackReference(value = "shoppingCartItemsOtherProduct-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private OtherProduct otherProduct;
	
	public ShoppingCartItem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
