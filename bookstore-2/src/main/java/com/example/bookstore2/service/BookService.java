package com.example.bookstore2.service;

import com.example.bookstore2.dto.BookDtoIn;
import com.example.bookstore2.dto.BookDtoOut;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.entity.Book;
import com.example.bookstore2.filter.BookFilter;
import com.example.bookstore2.mapper.BookMapper;
import com.example.bookstore2.repository.BookRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  public BookService(BookRepository bookRepository,
      BookMapper bookMapper) {
    this.bookRepository = bookRepository;
    this.bookMapper = bookMapper;
  }

  public BookDtoOut create(BookDtoIn bookDtoIn) {
    Book book = bookMapper.toEntity(bookDtoIn);
    Book saved = bookRepository.save(book);
    return bookMapper.toDto(saved);
  }

  public BookDtoOut update(long id, BookDtoIn bookDtoIn) {
    return bookRepository.findById(id)
            .map(entity -> {
              var updated = bookMapper.toEntity(bookDtoIn);
              updated.setId(entity.getId());
              return bookRepository.save(updated);
            })
            .map(bookMapper::toDto)
            .orElse(null);
  }

  public BookDtoOut delete(long id) {
    return bookRepository.findById(id)
            .map(entity -> {
              bookRepository.delete(entity);
              return entity;
            }).map(bookMapper::toDto)
            .orElse(null);
  }

  public BookDtoOut get(long id) {
    return bookRepository.findById(id).map(bookMapper::toDto).orElse(null);

  }

  public List<BookDtoOut> list(BookFilter bookFilter) {
    return null;
  }

}
