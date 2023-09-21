package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.GenreDto;
import com.example.bookstore2.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface GenreMapper {

  GenreDto toDto(Genre genre);

  @Mapping(target = "id", ignore = true)
  Genre toEntity(GenreDto genreDto);

}
