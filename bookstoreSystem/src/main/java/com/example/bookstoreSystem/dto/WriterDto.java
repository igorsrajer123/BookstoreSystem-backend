package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.Writer;

public class WriterDto {

	private Long id;
	private String name;
	private String description;
	private String image;
	
	public WriterDto() {
		super();
	}
	
	public WriterDto(Writer w) {
		this(w.getId(), w.getName(), w.getDescription(), w.getImage());
	}
	
	public WriterDto(Long id, String name, String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
}
