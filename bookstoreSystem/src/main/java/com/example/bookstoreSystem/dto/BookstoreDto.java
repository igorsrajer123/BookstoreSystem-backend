package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.Bookstore;

public class BookstoreDto {

	private Long id;
	private String name;
	private String address;
	private String city;
	private String contactPhone;
	private String photo;
	private double rating;
	private int numberOfVotes;
	
	public BookstoreDto() {
		super();
	}
	
	public BookstoreDto(Bookstore b) {
		this(b.getId(), b.getName(), b.getAddress(), b.getCity(), b.getContactPhone(), b.getPhoto(), b.getRating(), b.getNumberOfVotes());
	}
	
	public BookstoreDto(Long id, String name, String address, String city, String contactPhone, String photo, double rating, int numberOfVotes) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.contactPhone = contactPhone;
		this.photo = photo;
		this.rating = rating;
		this.numberOfVotes = numberOfVotes;
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
	
	public String getContactPhone() {
		return contactPhone;
	}
	
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public int getNumberOfVotes() {
		return numberOfVotes;
	}
	
	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
}
