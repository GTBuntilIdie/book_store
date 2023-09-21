package com.example.bookstore2.security;

import com.example.bookstore2.dto.UserDto;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class BookstoreUserDetails implements UserDetails {

  private UserDto userDto;

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Optional.ofNullable(userDto)
        .map(UserDto::getRole)
        .map(role -> "ROLE_" + role.name())
        .map(SimpleGrantedAuthority::new)
        .map(Collections::singleton)
        .orElseGet(Collections::emptySet);
  }

  @Override
  public String getPassword() {
    return Optional.ofNullable(userDto)
        .map(UserDto::getPassword)
        .orElse(null);
  }

  @Override
  public String getUsername() {
    return Optional.ofNullable(userDto)
        .map(UserDto::getLogin)
        .orElse(null);
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
