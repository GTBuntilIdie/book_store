package com.example.bookstore2.filter;

import jakarta.validation.constraints.Size;

public class GenreFilter extends BaseFilter{

  @Size(max = 12)
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
