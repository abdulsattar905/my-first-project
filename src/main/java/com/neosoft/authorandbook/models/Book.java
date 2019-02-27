package com.neosoft.authorandbook.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(generator = "book_id_gen", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "book_id_gen", strategy = "native")
	private Long id;

	private String bookName;

	private Long bookIsbn;

	@ManyToMany(mappedBy = "books")
	Set<Author> authors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Long getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(Long bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
