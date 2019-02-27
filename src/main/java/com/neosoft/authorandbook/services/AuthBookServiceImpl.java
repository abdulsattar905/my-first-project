package com.neosoft.authorandbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.authorandbook.dtos.AuthorCreateDto;
import com.neosoft.authorandbook.dtos.AuthorDto;
import com.neosoft.authorandbook.dtos.BookCreateDto;
import com.neosoft.authorandbook.dtos.BookDto;
import com.neosoft.authorandbook.models.Author;
import com.neosoft.authorandbook.models.Book;
import com.neosoft.authorandbook.repositories.AuthorRepository;
import com.neosoft.authorandbook.repositories.BookRepository;

@Service
public class AuthBookServiceImpl implements AuthBookService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	@Override
	public AuthorDto createAuthor(AuthorCreateDto authorCreateDto) {
		Author author = new Author();
		author.setName(authorCreateDto.getName());
		
		author = authorRepository.save(author);
		
		return toAuhtorDto(author);
	}
	
	@Transactional
	@Override
	public AuthorDto updateAuthor(Long id, AuthorCreateDto authorCreateDto) {
		Author author = authorRepository.findById(id).get();
		
		author.setName(authorCreateDto.getName());
		
		authorRepository.save(author);
		
		return toAuhtorDto(author);
	}
	
	@Transactional
	@Override
	public void assignBooks(Long id, Long bookId) {
		Author author = authorRepository.findById(id).get();
		Book book = bookRepository.findById(bookId).get();
		author.getBooks().add(book);
	}

	@Override
	public List<AuthorDto> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		
		List<AuthorDto> authorDtos = new ArrayList<>(authors.size());
		for (Author author : authors) {
			authorDtos.add(toAuhtorDto(author));
		}
		
		return authorDtos;
	}
	
	@Transactional
	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
	
	@Override
	public BookDto createBook(BookCreateDto bookCreateDto) {
		Book book = new Book();
		book.setBookName(bookCreateDto.getBookName());
		book.setBookIsbn(bookCreateDto.getBookIsbn());
		
		book = bookRepository.save(book);
		
		return toBookDto(book);
	}
	
	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		
		List<BookDto> bookDtos = new ArrayList<>(books.size());
		for (Book book : books) {
			bookDtos.add(toBookDto(book));
		}
		
		return bookDtos;
	}
	
	private AuthorDto toAuhtorDto(Author author) {
		AuthorDto authorDto = new AuthorDto();
		authorDto.setId(author.getId());
		authorDto.setName(author.getName());
		return authorDto;
	}
	
	private BookDto toBookDto(Book book) {
		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setIsbn(book.getBookIsbn());
		bookDto.setName(book.getBookName());
		
		return bookDto;
	}

	@Override
	public BookDto updateBook(Long id, BookCreateDto bookCreateDto) {
		Book book = bookRepository.findById(id).get();
		
		book.setBookName(bookCreateDto.getBookName());
		book.setBookIsbn(bookCreateDto.getBookIsbn());
		bookRepository.save(book);
		
		return toBookDto(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}		
	
}
