package com.example.bookstore2.repository;

import com.example.bookstore2.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByLogin(String login);

}
