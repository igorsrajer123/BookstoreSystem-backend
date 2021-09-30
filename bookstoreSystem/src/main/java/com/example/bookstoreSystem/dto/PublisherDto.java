package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.Publisher;

public class PublisherDto {

	private Long id;
	private String name;
	private String address;
	private String city;
	private String phoneNumber;
	
	public PublisherDto() {
		super();
	}
	
	public PublisherDto(Publisher p) {
		this(p.getId(), p.getName(), p.getAddress(), p.getCity(), p.getPhoneNumber());
	}
	
	public PublisherDto(Long id, String name, String address, String city, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
