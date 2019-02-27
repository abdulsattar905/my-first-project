package com.neosoft.authorandbook.dtos;

public class BookCreateDto {

	private String bookName;

	private Long bookIsbn;

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

	

}
