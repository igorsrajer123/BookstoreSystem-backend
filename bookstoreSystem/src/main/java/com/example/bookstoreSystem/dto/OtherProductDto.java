package com.example.bookstoreSystem.dto;

import java.time.LocalDate;

import com.example.bookstoreSystem.model.OtherProduct;
import com.example.bookstoreSystem.model.ProductType;

public class OtherProductDto {

	private Long id;
	private String name;
	private String code;
	private String description;
	private double price;
	private LocalDate published;
	private ProductType type;
	private String coverImage;
	private PublisherDto publisher;
	private LocalDate expirationDate;
	
	public OtherProductDto() {
		super();
	}
	
	public OtherProductDto(OtherProduct o) {
		this(o.getId(), o.getCode(), o.getName(), o.getDescription(), o.getPrice(), o.getPublished(), o.getType(), o.getCoverImage(), new PublisherDto(o.getPublisher()), o.getExpirationDate());
	}
	
	public OtherProductDto(Long id, String code, String name, String description, double price, LocalDate published, ProductType type, String coverImage, PublisherDto publisher, LocalDate expirationDate) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
		this.published = published;
		this.type = type;
		this.coverImage = coverImage;
		this.publisher = publisher;
		this.setExpirationDate(expirationDate);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublished() {
		return published;
	}

	public void setPublished(LocalDate published) {
		this.published = published;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public PublisherDto getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
}
