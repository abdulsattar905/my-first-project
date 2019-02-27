package com.neosoft.authorandbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.authorandbook.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
