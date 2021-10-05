package com.example.bookstoreSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book extends Product{

	@Column(name = "numberOfPages", nullable = true)
	private int numberOfPages;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "language", nullable = true)
	private BookLanguage language;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "coverType", nullable = true)
	private BookCoverType coverType;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "genreBooks", joinColumns = @JoinColumn(name = "bookId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genreId", referencedColumnName = "id"))
	private List<Genre> genres;
	
	@JsonManagedReference(value = "bookBookstores-movement")
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BooksBookstores> booksInBookstores;
	
	public Book() {
		super();
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public BookLanguage getLanguage() {
		return language;
	}

	public void setLanguage(BookLanguage language) {
		this.language = language;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public BookCoverType getCoverType() {
		return coverType;
	}

	public void setCoverType(BookCoverType coverType) {
		this.coverType = coverType;
	}

	public List<BooksBookstores> getBooksInBookstores() {
		return booksInBookstores;
	}

	public void setBooksInBookstores(List<BooksBookstores> booksInBookstores) {
		this.booksInBookstores = booksInBookstores;
	}
}
