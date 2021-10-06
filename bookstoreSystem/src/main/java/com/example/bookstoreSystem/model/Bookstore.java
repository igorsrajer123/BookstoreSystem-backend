package com.example.bookstoreSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Bookstore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "contactPhone")
	private String contactPhone;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "rating")
	private double rating;
	
	@Column(name = "numberOfVotes")
	private int numberOfVotes;
	
	@JsonIgnoreProperties(value = {"bookstore"}, allowSetters = true)
	@OneToMany(mappedBy = "bookstore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BookstoreAdministrator> bookstoreAdministrators;
	
	@JsonIgnoreProperties(value = {"bookstore"}, allowSetters = true)
	@OneToMany(mappedBy = "bookstore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Seller> bookstoreSellers;
	
	@JsonManagedReference(value = "bookstoreBooks-movement")
	@OneToMany(mappedBy = "bookstore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BooksBookstores> booksInBookstores;
	
	@JsonManagedReference(value = "bookstoreOtherProducts-movement")
	@OneToMany(mappedBy = "bookstore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OtherProductsBookstores> otherProductsInBookstores;
	
	@JsonManagedReference(value = "cashRegister-movement")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CashRegister cashRegister;
	
	public Bookstore() {
		super();
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

	public List<BookstoreAdministrator> getBookstoreAdministrators() {
		return bookstoreAdministrators;
	}

	public void setBookstoreAdministrators(List<BookstoreAdministrator> bookstoreAdministrators) {
		this.bookstoreAdministrators = bookstoreAdministrators;
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

	public List<Seller> getBookstoreSellers() {
		return bookstoreSellers;
	}

	public void setBookstoreSellers(List<Seller> bookstoreSellers) {
		this.bookstoreSellers = bookstoreSellers;
	}

	public List<BooksBookstores> getBooksInBookstores() {
		return booksInBookstores;
	}

	public void setBooksInBookstores(List<BooksBookstores> booksInBookstores) {
		this.booksInBookstores = booksInBookstores;
	}

	public List<OtherProductsBookstores> getOtherProductsInBookstores() {
		return otherProductsInBookstores;
	}

	public void setOtherProductsInBookstores(List<OtherProductsBookstores> otherProductsInBookstores) {
		this.otherProductsInBookstores = otherProductsInBookstores;
	}

	public CashRegister getCashRegister() {
		return cashRegister;
	}

	public void setCashRegister(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
	}
}
