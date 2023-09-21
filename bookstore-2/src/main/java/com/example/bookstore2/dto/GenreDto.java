package com.example.bookstore2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GenreDto {

  @Schema(name = "id", description = "id жанра")
  private Long id;

  @Schema(name = "title", description = "Название жанра", maxLength = 12, example = "Приключение")
  @NotBlank
  @Size(max = 12)
  private String title;

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

}
