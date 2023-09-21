package com.example.bookstore2.repository;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<AuthorDto> findByName(String name);

}
