package com.example.bookstoreSystem.dto;

import java.time.LocalDateTime;

import com.example.bookstoreSystem.model.Delivery;
import com.example.bookstoreSystem.model.DeliveryStatus;

public class DeliveryDto {

	private Long id;
	private LocalDateTime createdDate;
	private String contactPhone;
	private String deliveryAddress;
	private String postalCode;
	private double price;
	private DeliveryStatus status;
	private String note;
	private CustomerDto customer;
	
	public DeliveryDto() {
		super();
	}
	
	public DeliveryDto(Delivery d) {
		this(d.getId(), d.getCreatedDate(), d.getContactPhone(), d.getDeliveryAddress(), d.getPostalCode(), d.getPrice(), d.getStatus(), d.getNote(), new CustomerDto(d.getCustomer()));
	}
	
	public DeliveryDto(Long id, LocalDateTime createdDate, String contactPhone, String deliveryAddress, String postalCode, double price, DeliveryStatus status, String note, CustomerDto customer) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.contactPhone = contactPhone;
		this.deliveryAddress = deliveryAddress;
		this.postalCode = postalCode;
		this.price = price;
		this.status = status;
		this.note = note;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
}
