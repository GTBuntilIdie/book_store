package com.example.bookstore2.controller;

import com.example.bookstore2.dto.GenreDto;
import com.example.bookstore2.filter.GenreFilter;
import com.example.bookstore2.service.GenreService;
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
@RequestMapping("/genres")
@Tag(name = "API для жанров", description = "Эндпоинты для работы с жанрами")
public class GenreController {

  private final GenreService genreService;

  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @Operation(
      summary = "Создание жанра",
      responses = {
          @ApiResponse(responseCode = "201", description = "Жанр создан успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в полях"),
          @ApiResponse(responseCode = "409", description = "Жанр с таким названием уже был создан")
      }
  )
  @PostMapping
  public ResponseEntity<GenreDto> create(@Valid @RequestBody GenreDto genreDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(genreService.create(genreDto));
  }

  @Operation(
      summary = "Обновление жанра",
      responses = {
          @ApiResponse(responseCode = "200", description = "Жанр обновлён успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в полях"),
          @ApiResponse(responseCode = "404", description = "Жанр не найден по id")
      }
  )
  @PutMapping("/{id}")
  public GenreDto update(@PathVariable long id,
      @Valid @RequestBody GenreDto genreDto) {
    return genreService.update(id, genreDto);
  }

  @Operation(
      summary = "Удаление жанра",
      responses = {
          @ApiResponse(responseCode = "200", description = "Жанр удалён успешно"),
          @ApiResponse(responseCode = "404", description = "Жанр не найден по id")
      }
  )
  @DeleteMapping("/{id}")
  public GenreDto delete(@PathVariable long id) {
    return genreService.delete(id);
  }

  @Operation(
      summary = "Получение жанра",
      responses = {
          @ApiResponse(responseCode = "200", description = "Жанр получен успешно"),
          @ApiResponse(responseCode = "404", description = "Жанр не найден по id")
      }
  )
  @GetMapping("/{id}")
  public GenreDto get(@PathVariable long id) {
    return genreService.get(id);
  }

  @Operation(
      summary = "Получение жанров по фильтру",
      responses = {
          @ApiResponse(responseCode = "200", description = "Жанры получены успешно"),
          @ApiResponse(responseCode = "400", description = "Некорректные значения в фильтре")
      }
  )
  @GetMapping
  public List<GenreDto> list(@Valid GenreFilter genreFilter) {
    return genreService.list(genreFilter);
  }

}
