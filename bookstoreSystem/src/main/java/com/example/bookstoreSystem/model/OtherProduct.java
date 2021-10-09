package com.example.bookstoreSystem.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class OtherProduct extends Product{

	@Column(name = "expirationDate", nullable = true)
	private LocalDate expirationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	protected ProductType type;
	
	@JsonManagedReference(value = "otherProductBookstores-movement")
	@OneToMany(mappedBy = "otherProduct", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OtherProductsBookstores> otherProductsInBookstores;
	
	@JsonManagedReference(value = "otherProductReceiptItem-movement")
	@OneToMany(mappedBy = "otherProduct", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReceiptItem> otherProductReceiptItems;
	
	@JsonManagedReference(value = "shoppingCartItemsOtherProduct-movement")
	@OneToMany(mappedBy = "otherProduct", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private List<ShoppingCartItem> shoppingCartItems;
	
	@JsonManagedReference(value = "otherProductDeliveryItem-movement")
	@OneToMany(mappedBy = "otherProduct", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DeliveryItem> deliveryItems;
	
	public OtherProduct() {
		super();
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public List<OtherProductsBookstores> getOtherProductsInBookstores() {
		return otherProductsInBookstores;
	}

	public void setOtherProductsInBookstores(List<OtherProductsBookstores> otherProductsInBookstores) {
		this.otherProductsInBookstores = otherProductsInBookstores;
	}

	public List<ReceiptItem> getOtherProductReceiptItems() {
		return otherProductReceiptItems;
	}

	public void setOtherProductReceiptItems(List<ReceiptItem> otherProductReceiptItems) {
		this.otherProductReceiptItems = otherProductReceiptItems;
	}

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	public List<DeliveryItem> getDeliveryItems() {
		return deliveryItems;
	}

	public void setDeliveryItems(List<DeliveryItem> deliveryItems) {
		this.deliveryItems = deliveryItems;
	}
}
