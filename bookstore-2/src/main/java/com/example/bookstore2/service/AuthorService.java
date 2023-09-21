package com.example.bookstore2.service;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.filter.AuthorFilter;
import com.example.bookstore2.mapper.AuthorMapper;
import com.example.bookstore2.repository.AuthorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  public AuthorService(AuthorRepository authorRepository,
      AuthorMapper authorMapper) {
    this.authorRepository = authorRepository;
    this.authorMapper = authorMapper;
  }

  public AuthorDto create(AuthorDto authorDto) {
    Author author = authorMapper.toEntity(authorDto);
    Author saved = authorRepository.save(author);
    return authorMapper.toDto(saved);
  }

  public AuthorDto update(long id, AuthorDto authorDto) {
    return authorRepository.findById(id)
            .map(entity -> {
              var updated = authorMapper.toEntity(authorDto);
              updated.setId(entity.getId());
              return authorRepository.save(updated);
            })
            .map(authorMapper::toDto)
            .orElse(null);
  }

  public AuthorDto delete(long id) {
    return authorRepository.findById(id)
            .map(entity -> {
              authorRepository.delete(entity);
              return entity;
            }).map(authorMapper::toDto)
            .orElse(null);
  }

  public AuthorDto get(long id) {
    return authorRepository.findById(id).map(authorMapper::toDto).orElse(null);
  }

  public List<AuthorDto> list(AuthorFilter authorFilter) {
    return authorRepository.findByName(authorFilter.getName());
  }

}
