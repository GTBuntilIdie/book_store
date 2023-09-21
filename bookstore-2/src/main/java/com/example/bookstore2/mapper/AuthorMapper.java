package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AuthorMapper {

  AuthorDto toDto(Author author);

  @Mapping(target = "id", ignore = true)
  Author toEntity(AuthorDto authorDto);

}
