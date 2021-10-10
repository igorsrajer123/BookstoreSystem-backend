package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.ShoppingCartItem;

public class ShoppingCartItemDto {

	private Long id;
	private int amount;
	private ShoppingCartDto shoppingCart;
	private BookDto book;
	private OtherProductDto otherProduct;
	
	public ShoppingCartItemDto() {
		super();
	}
	
	public ShoppingCartItemDto(ShoppingCartItem s) {
		this(s.getId(), s.getAmount(), new ShoppingCartDto(s.getShoppingCart()), new BookDto(s.getBook()), new OtherProductDto(s.getOtherProduct()));
	}
	
	public ShoppingCartItemDto(Long id, int amount, ShoppingCartDto shoppingCart, BookDto book, OtherProductDto otherProduct) {
		super();
		this.id = id;
		this.amount = amount;
		this.shoppingCart = shoppingCart;
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

	public ShoppingCartDto getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartDto shoppingCart) {
		this.shoppingCart = shoppingCart;
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
