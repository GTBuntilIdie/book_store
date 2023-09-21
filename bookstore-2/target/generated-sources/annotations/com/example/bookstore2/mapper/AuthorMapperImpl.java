package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.entity.Author;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T19:29:55+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDto toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( author.getId() );
        authorDto.setName( author.getName() );
        authorDto.setSurname( author.getSurname() );
        authorDto.setBirthDate( author.getBirthDate() );

        return authorDto;
    }

    @Override
    public Author toEntity(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( authorDto.getName() );
        author.setSurname( authorDto.getSurname() );
        author.setBirthDate( authorDto.getBirthDate() );

        return author;
    }
}
