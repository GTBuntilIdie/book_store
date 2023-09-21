package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.UserDto;
import com.example.bookstore2.entity.Role;
import com.example.bookstore2.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T19:29:55+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        String login = null;
        String password = null;
        Role role = null;

        login = user.getLogin();
        password = user.getPassword();
        role = user.getRole();

        UserDto userDto = new UserDto( login, password, role );

        return userDto;
    }
}
