package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.GenreDto;
import com.example.bookstore2.entity.Genre;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T19:29:55+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDto toDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setId( genre.getId() );
        genreDto.setTitle( genre.getTitle() );

        return genreDto;
    }

    @Override
    public Genre toEntity(GenreDto genreDto) {
        if ( genreDto == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setTitle( genreDto.getTitle() );

        return genre;
    }
}
