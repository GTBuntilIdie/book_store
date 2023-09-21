package com.example.bookstore2.service;

import com.example.bookstore2.dto.GenreDto;
import com.example.bookstore2.filter.GenreFilter;
import com.example.bookstore2.mapper.GenreMapper;
import com.example.bookstore2.repository.GenreRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class GenreService {

  private final GenreRepository genreRepository;
  private final GenreMapper genreMapper;

  public GenreService(GenreRepository genreRepository,
      GenreMapper genreMapper) {
    this.genreRepository = genreRepository;
    this.genreMapper = genreMapper;
  }

  public GenreDto create(GenreDto genreDto) {
    return genreMapper.toDto(genreRepository.save(genreMapper.toEntity(genreDto)));
  }

  public GenreDto update(long id, GenreDto genreDto) {
    return genreRepository.findById(id)
            .map(entity -> {
              entity.setTitle(genreDto.getTitle());
              genreRepository.save(entity);
              return entity;
            })
            .map(genreMapper::toDto)
            .orElse(null);
  }

  public GenreDto delete(long id) {
    return Optional.ofNullable(get(id))
            .map(dto -> {
              genreRepository.deleteById(id);
              return dto;
            })
            .orElse(null);

  }

  public GenreDto get(long id) {
    return genreRepository.findById(id).map(genreMapper::toDto).orElse(null);
  }

  public List<GenreDto> list(GenreFilter genreFilter) {
    return null;
  }

}
