package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.BookDtoIn;
import com.example.bookstore2.dto.BookDtoOut;
import com.example.bookstore2.dto.GenreDto;
import com.example.bookstore2.entity.Book;
import com.example.bookstore2.entity.Genre;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T19:29:55+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private GenreMapper genreMapper;

    @Override
    public BookDtoOut toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoOut bookDtoOut = new BookDtoOut();

        bookDtoOut.setId( book.getId() );
        bookDtoOut.setTitle( book.getTitle() );
        bookDtoOut.setPublicationDate( book.getPublicationDate() );
        bookDtoOut.setPages( book.getPages() );
        bookDtoOut.setAuthor( authorMapper.toDto( book.getAuthor() ) );
        bookDtoOut.setGenres( genreSetToGenreDtoSet( book.getGenres() ) );

        return bookDtoOut;
    }

    @Override
    public Book toEntity(BookDtoIn bookDtoIn) {
        if ( bookDtoIn == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookDtoIn.getTitle() );
        book.setPublicationDate( bookDtoIn.getPublicationDate() );
        book.setPages( bookDtoIn.getPages() );

        return book;
    }

    protected Set<GenreDto> genreSetToGenreDtoSet(Set<Genre> set) {
        if ( set == null ) {
            return null;
        }

        Set<GenreDto> set1 = new LinkedHashSet<GenreDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Genre genre : set ) {
            set1.add( genreMapper.toDto( genre ) );
        }

        return set1;
    }
}
