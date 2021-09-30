package com.example.bookstoreSystem.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class OtherProduct extends Product{

	@Column(name = "expirationDate", nullable = true)
	private LocalDate expirationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	protected ProductType type;
	
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
}
