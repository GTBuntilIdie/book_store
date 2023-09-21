package com.example.bookstore2.controller;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.filter.AuthorFilter;
import com.example.bookstore2.service.AuthorService;
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
@RequestMapping("/authors")
@Tag(name = "API для авторов", description = "Эндпоинты для работы с авторами")
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @Operation(
      summary = "Создание автора",
      responses = {
          @ApiResponse(responseCode = "201", description = "Автор создан успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в полях")
      }
  )
  @PostMapping
  public ResponseEntity<AuthorDto> create(@Valid @RequestBody AuthorDto authorDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(authorDto));
  }

  @Operation(
      summary = "Обновление автора",
      responses = {
          @ApiResponse(responseCode = "200", description = "Автор обновлён успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в полях"),
          @ApiResponse(responseCode = "404", description = "Автор не найден по id")
      }
  )
  @PutMapping("/{id}")
  public AuthorDto update(@PathVariable long id,
      @Valid @RequestBody AuthorDto authorDto) {
    return authorService.update(id, authorDto);
  }

  @Operation(
      summary = "Удаление автора",
      responses = {
          @ApiResponse(responseCode = "200", description = "Автор удалён успешно"),
          @ApiResponse(responseCode = "404", description = "Автор не найден по id")
      }
  )
  @DeleteMapping("/{id}")
  public AuthorDto delete(@PathVariable long id) {
    return authorService.delete(id);
  }

  @Operation(
      summary = "Получение автора",
      responses = {
          @ApiResponse(responseCode = "200", description = "Автор получен успешно"),
          @ApiResponse(responseCode = "404", description = "Автор не найден по id")
      }
  )
  @GetMapping("/{id}")
  public AuthorDto get(@PathVariable long id) {
    return authorService.get(id);
  }

  @Operation(
      summary = "Получение авторов по фильтру",
      responses = {
          @ApiResponse(responseCode = "200", description = "Авторы получены успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в фильтре")
      }
  )
  @GetMapping
  public List<AuthorDto> list(@Valid AuthorFilter authorFilter) {
    return authorService.list(authorFilter);
  }

}
