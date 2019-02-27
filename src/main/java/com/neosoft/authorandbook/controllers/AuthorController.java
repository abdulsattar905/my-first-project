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

import com.neosoft.authorandbook.dtos.AuthorCreateDto;
import com.neosoft.authorandbook.dtos.AuthorDto;
import com.neosoft.authorandbook.services.AuthBookService;

@RestController
@RequestMapping("/authors")
@CrossOrigin
public class AuthorController {
	
	@Autowired
	private AuthBookService authorBookService;
	
	@PostMapping
	public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
		AuthorDto authorDto = authorBookService.createAuthor(authorCreateDto);
		
		return new ResponseEntity<>(authorDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorCreateDto authorCreateDto, @PathVariable Long id) {
		AuthorDto authorDto = authorBookService.updateAuthor(id, authorCreateDto);
		
		return new ResponseEntity<>(authorDto, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/books/{bookId}")
	public void assignBooks(@PathVariable Long id, @PathVariable Long bookId) {
		authorBookService.assignBooks(id, bookId);
	}
	
	
	@GetMapping
	public ResponseEntity<List<AuthorDto>> getAllAuthors() {
		List<AuthorDto> authors = authorBookService.getAllAuthors();
		
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
		authorBookService.deleteAuthor(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
