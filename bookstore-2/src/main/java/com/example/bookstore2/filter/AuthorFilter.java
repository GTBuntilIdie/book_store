package com.example.bookstore2.filter;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class AuthorFilter extends BaseFilter {

  @Size(max = 10)
  private String name;

  @Size(max = 12)
  private String surname;

  @Past
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private LocalDate birthDate;

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
