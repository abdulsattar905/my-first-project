package com.neosoft.authorandbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neosoft.authorandbook.dtos.BookCreateDto;
import com.neosoft.authorandbook.dtos.BookDto;
import com.neosoft.authorandbook.services.AuthBookService;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
	
	@Autowired
	private AuthBookService authorBookService;

	@PostMapping
	public ResponseEntity<BookDto> createBook(@RequestBody BookCreateDto bookCreateDto) {
		BookDto bookDto = authorBookService.createBook(bookCreateDto);
		
		return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookCreateDto bookCreateDto, @PathVariable Long id) {
		BookDto bookDto = authorBookService.updateBook(id, bookCreateDto);
		
		return new ResponseEntity<>(bookDto, HttpStatus.OK);
	}
	
	@PutMapping("/{bookId}/author/{authorId}")
	public void assignAuthor(@PathVariable Long bookId, @PathVariable Long authorId) {
		authorBookService.assignBooks(authorId, bookId);
	}
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks() {
		List<BookDto> books = authorBookService.getAllBooks();
		
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		authorBookService.deleteBook(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
