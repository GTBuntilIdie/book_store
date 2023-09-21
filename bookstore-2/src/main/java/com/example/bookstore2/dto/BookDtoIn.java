package com.example.bookstore2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;

public class BookDtoIn {

  @Schema(name = "title", description = "Название книги", maxLength = 20, example = "Капитанская дочка")
  @NotBlank
  @Size(max = 20)
  private String title;

  @Schema(name = "publicationDate", description = "Дата публикации книги", pattern = "dd.MM.yyyy", example = "12.02.1725")
  @NotNull
  @Past
  @JsonFormat(pattern = "dd.MM.yyyy")
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private LocalDate publicationDate;

  @Schema(name = "pages", description = "Количество страниц в книге", minimum = "1", example = "473")
  @NotBlank
  @Positive
  private int pages;

  @Schema(name = "authorId", description = "id автора книги", minimum = "1", example = "1")
  @NotBlank
  @Positive
  private long authorId;

  @Schema(name = "genreIds", description = "id жанров книги", example = "[1, 2]")
  @NotEmpty
  private Set<@Positive Long> genreIds;

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

  public long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(long authorId) {
    this.authorId = authorId;
  }

  public Set<Long> getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(Set<Long> genreIds) {
    this.genreIds = genreIds;
  }

}
