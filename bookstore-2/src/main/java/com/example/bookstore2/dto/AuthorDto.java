package com.example.bookstore2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class AuthorDto {

  @Schema(name = "id", description = "id автора")
  private Long id;

  @Schema(name = "name", description = "Имя автора", maxLength = 10, example = "Александр")
  @NotBlank
  @Size(max = 10)
  private String name;

  @Schema(name = "surname", description = "Фамилия автора", maxLength = 12, example = "Пушкин")
  @NotBlank
  @Size(max = 12)
  private String surname;

  @Schema(name = "birthDate", description = "Дата рождения автора", pattern = "dd.MM.yyyy", example = "12.02.1725")
  @NotNull
  @Past
  @JsonFormat(pattern = "dd.MM.yyyy")
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private LocalDate birthDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

}
