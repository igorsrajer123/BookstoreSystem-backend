package com.example.bookstoreSystem.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;
	
	@Column(name = "code", nullable = false, unique = true)
	protected String code;
	
	@Column(name = "name", nullable = false)
	protected String name;
	
	@Column(name = "description", nullable = false)
	protected String description;
	
	@Column(name = "price", nullable = false)
	protected double price;
	
	@Column(name = "published", nullable = false)
	protected LocalDate published;
	
	@Column(name = "coverImage", nullable = true)
	protected String coverImage;
	
	@JsonIgnoreProperties("products")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected Publisher publisher;

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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
}
