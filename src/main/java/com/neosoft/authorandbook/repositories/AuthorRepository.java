package com.neosoft.authorandbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.authorandbook.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
