package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.UserDto;
import com.example.bookstore2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

  UserDto toDto(User user);

}
