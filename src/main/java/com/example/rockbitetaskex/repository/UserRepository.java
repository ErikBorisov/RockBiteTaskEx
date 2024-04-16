package com.example.rockbitetaskex.repository;

import com.example.rockbitetaskex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
