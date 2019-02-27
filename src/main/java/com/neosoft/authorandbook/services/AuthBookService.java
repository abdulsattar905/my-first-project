package com.neosoft.authorandbook.services;

import java.util.List;

import com.neosoft.authorandbook.dtos.AuthorCreateDto;
import com.neosoft.authorandbook.dtos.AuthorDto;
import com.neosoft.authorandbook.dtos.BookCreateDto;
import com.neosoft.authorandbook.dtos.BookDto;

public interface AuthBookService {

	AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
	
	AuthorDto updateAuthor(Long id, AuthorCreateDto authorCreateDto);

	List<AuthorDto> getAllAuthors();

	void deleteAuthor(Long id);

	BookDto createBook(BookCreateDto bookCreateDto);

	List<BookDto> getAllBooks();

	BookDto updateBook(Long id, BookCreateDto bookCreateDto);

	void deleteBook(Long id);

	void assignBooks(Long id, Long bookId);

}
