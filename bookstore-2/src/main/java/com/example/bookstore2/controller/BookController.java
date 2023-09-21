package com.example.bookstore2.controller;

import com.example.bookstore2.dto.BookDtoIn;
import com.example.bookstore2.dto.BookDtoOut;
import com.example.bookstore2.filter.BookFilter;
import com.example.bookstore2.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@Tag(name = "API для книг", description = "Эндпоинты для работы с книгами")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @Operation(
      summary = "Создание книги",
      responses = {
          @ApiResponse(responseCode = "201", description = "Книга создана успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в полях")
      }
  )
  @PostMapping
  public ResponseEntity<BookDtoOut> create(@Valid @RequestBody BookDtoIn bookDtoIn) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(bookDtoIn));
  }

  @Operation(
      summary = "Обновление книги",
      responses = {
          @ApiResponse(responseCode = "200", description = "Книга обновлена успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в полях"),
          @ApiResponse(responseCode = "404", description = "Книга не найдена по id")
      }
  )
  @PutMapping("/{id}")
  public BookDtoOut update(@PathVariable long id,
      @Valid @RequestBody BookDtoIn bookDtoIn) {
    return bookService.update(id, bookDtoIn);
  }

  @Operation(
      summary = "Удаление книги",
      responses = {
          @ApiResponse(responseCode = "200", description = "Книга удалена успешно"),
          @ApiResponse(responseCode = "404", description = "Книга не найдена по id")
      }
  )
  @DeleteMapping("/{id}")
  public BookDtoOut delete(@PathVariable long id) {
    return bookService.delete(id);
  }

  @Operation(
      summary = "Получение книги",
      responses = {
          @ApiResponse(responseCode = "200", description = "Книга получена успешно"),
          @ApiResponse(responseCode = "404", description = "Книга не найдена по id")
      }
  )
  @GetMapping("/{id}")
  public BookDtoOut get(@PathVariable long id) {
    return bookService.get(id);
  }

  @Operation(
      summary = "Получение книг по фильтру",
      responses = {
          @ApiResponse(responseCode = "200", description = "Книги получены успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в фильтре")
      }
  )
  @GetMapping
  public List<BookDtoOut> list(@Valid BookFilter bookFilter) {
    return bookService.list(bookFilter);
  }

}
