package com.example.bookstore2.security;

import com.example.bookstore2.mapper.UserMapper;
import com.example.bookstore2.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookstoreUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
  private final BookstoreUserDetails bookstoreUserDetails;
  private final UserMapper userMapper;

  public BookstoreUserDetailsService(UserRepository userRepository,
      BookstoreUserDetails bookstoreUserDetails,
      UserMapper userMapper) {
    this.userRepository = userRepository;
    this.bookstoreUserDetails = bookstoreUserDetails;
    this.userMapper = userMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByLogin(username)
        .map(user -> {
          bookstoreUserDetails.setUserDto(userMapper.toDto(user));
          return bookstoreUserDetails;
        })
        .orElseThrow(() -> new UsernameNotFoundException(
                "Пользователь с логином " + username + " не найден!"
            )
        );
  }

}
