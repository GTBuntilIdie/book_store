package com.example.bookstore2.filter;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class BookFilter extends BaseFilter {

  @Size(max = 20)
  private String title;

  @Past
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private LocalDate publicationDate;

  @Positive
  private Integer minPages;

  @Positive
  private Integer maxPages;

  @Size(max = 12)
  private String author;

  @Size(max = 12)
  private String genre;

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

  public Integer getMinPages() {
    return minPages;
  }

  public void setMinPages(Integer minPages) {
    this.minPages = minPages;
  }

  public Integer getMaxPages() {
    return maxPages;
  }

  public void setMaxPages(Integer maxPages) {
    this.maxPages = maxPages;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

}
