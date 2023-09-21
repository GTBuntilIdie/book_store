package com.example.bookstore2.filter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public abstract class BaseFilter {

  @Min(0)
  private int page = 0;

  @Min(1)
  @Max(100)
  private int size = 10;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

}
