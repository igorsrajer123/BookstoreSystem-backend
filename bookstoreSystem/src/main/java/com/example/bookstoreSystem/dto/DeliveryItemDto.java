package com.example.bookstoreSystem.dto;

public class DeliveryItemDto {

	private Long id;
	private int amount;
	private DeliveryDto delivery;
	private BookDto book;
	private OtherProductDto otherProduct;
	
	public DeliveryItemDto() {
		super();
	}
	
	public DeliveryItemDto(Long id, int amount, DeliveryDto delivery, BookDto book, OtherProductDto otherProduct) {
		super();
		this.id = id;
		this.amount = amount;
		this.delivery = delivery;
		this.book  = book;
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

	public DeliveryDto getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryDto delivery) {
		this.delivery = delivery;
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
