package com.percy04demo1.percy04demo1.repository;

import com.percy04demo1.percy04demo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userepository extends JpaRepository<User, String> {
     boolean existsByUsername(String username);
     Optional<User> findByUsername(String username) ;
}

