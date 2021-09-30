package com.example.bookstoreSystem.dto;

import com.example.bookstoreSystem.model.Genre;

public class GenreDto {

	private Long id;
	private String name;
	
	public GenreDto() {
		super();
	}
	
	public GenreDto(Genre g) {
		this(g.getId(), g.getName());
	}
	
	public GenreDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
