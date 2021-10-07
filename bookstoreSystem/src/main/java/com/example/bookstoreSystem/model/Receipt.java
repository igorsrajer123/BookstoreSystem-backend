package com.example.bookstoreSystem.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	@Column(name = "value", nullable = false)
	private double value;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private ReceiptStatus status;
	
	@JsonIgnoreProperties("cashRegisterReceipts")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CashRegister cashRegister;
	
	@JsonBackReference(value = "createdReceipts-movement")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Seller seller;
	
	@JsonManagedReference(value = "receiptReceiptItem-movement")
	@OneToMany(mappedBy = "receipt", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReceiptItem> receiptItems;
	
	@Column(name = "dateAndTime", nullable = true)
	private LocalDateTime dateAndTime;
	
	public Receipt() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public CashRegister getCashRegister() {
		return cashRegister;
	}

	public void setCashRegister(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public ReceiptStatus getStatus() {
		return status;
	}

	public void setStatus(ReceiptStatus status) {
		this.status = status;
	}

	public List<ReceiptItem> getReceiptItems() {
		return receiptItems;
	}

	public void setReceiptItems(List<ReceiptItem> receiptItems) {
		this.receiptItems = receiptItems;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
}
