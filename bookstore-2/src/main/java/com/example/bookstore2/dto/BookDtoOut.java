package com.example.bookstore2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.Set;

public class BookDtoOut {

  @Schema(name = "id", description = "id книги", example = "1")
  private Long id;

  @Schema(name = "title", description = "Название книги", example = "Капитанская дочка")
  private String title;

  @Schema(name = "publicationDate", description = "Дата публикации книги", pattern = "dd.MM.yyyy", example = "12.02.1725")
  private LocalDate publicationDate;

  @Schema(name = "pages", description = "Количество страниц в книге", example = "473")
  private int pages;

  @Schema(name = "author", description = "Автора книги")
  private AuthorDto author;

  @Schema(name = "genres", description = "Жанры книги")
  private Set<GenreDto> genres;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(LocalDate publicationDate) {
    this.publicationDate = publicationDate;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public AuthorDto getAuthor() {
    return author;
  }

  public void setAuthor(AuthorDto author) {
    this.author = author;
  }

  public Set<GenreDto> getGenres() {
    return genres;
  }

  public void setGenres(Set<GenreDto> genres) {
    this.genres = genres;
  }

}
