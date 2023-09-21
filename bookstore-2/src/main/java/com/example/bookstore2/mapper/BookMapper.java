package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.BookDtoIn;
import com.example.bookstore2.dto.BookDtoOut;
import com.example.bookstore2.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {AuthorMapper.class, GenreMapper.class})
public interface BookMapper {

  BookDtoOut toDto(Book book);

  Book toEntity(BookDtoIn bookDtoIn);

}
