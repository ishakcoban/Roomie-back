package com.example.roomie.repository;

import com.example.roomie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  Optional<User> findById(String userId);
  Optional<User> findByUserName(String userName);
  boolean existsByEmail(String email);

}
