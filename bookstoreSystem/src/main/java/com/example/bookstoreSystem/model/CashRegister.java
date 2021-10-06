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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class CashRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@JsonBackReference(value = "cashRegister-movement")
	@OneToOne(mappedBy = "cashRegister", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Bookstore bookstore;
	
	@JsonIgnoreProperties(value = {"cashRegister"}, allowSetters = true)
	@OneToMany(mappedBy = "cashRegister", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Receipt> cashRegisterReceipts;

	public CashRegister() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Bookstore getBookstore() {
		return bookstore;
	}

	public void setBookstore(Bookstore bookstore) {
		this.bookstore = bookstore;
	}

	public List<Receipt> getCashRegisterReceipts() {
		return cashRegisterReceipts;
	}

	public void setCashRegisterReceipts(List<Receipt> cashRegisterReceipts) {
		this.cashRegisterReceipts = cashRegisterReceipts;
	}
}
