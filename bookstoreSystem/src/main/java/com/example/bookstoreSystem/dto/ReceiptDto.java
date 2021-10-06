package com.example.bookstoreSystem.dto;
import java.time.LocalDateTime;

import com.example.bookstoreSystem.model.Receipt;
import com.example.bookstoreSystem.model.ReceiptStatus;

public class ReceiptDto {

	private Long id;
	private int number;
	private CashRegisterDto cashRegister;
	private SellerDto seller;
	private double value;
	private ReceiptStatus status;
	private LocalDateTime dateAndTime;
	
	public ReceiptDto() {
		super();
	}
	
	public ReceiptDto(Receipt r) {
		this(r.getId(), r.getNumber(), new CashRegisterDto(r.getCashRegister()), new SellerDto(r.getSeller()), r.getValue(), r.getStatus(), r.getDateAndTime());
	}
	
	public ReceiptDto(Long id, int number, CashRegisterDto cashRegister, SellerDto seller, double value, ReceiptStatus status, LocalDateTime dateAndTime) {
		super();
		this.id = id;
		this.number = number;
		this.cashRegister = cashRegister;
		this.seller = seller;
		this.value = value;
		this.status = status;
		this.dateAndTime = dateAndTime;
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

	public CashRegisterDto getCashRegister() {
		return cashRegister;
	}

	public void setCashRegister(CashRegisterDto cashRegister) {
		this.cashRegister = cashRegister;
	}

	public SellerDto getSeller() {
		return seller;
	}

	public void setSeller(SellerDto seller) {
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

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
}
