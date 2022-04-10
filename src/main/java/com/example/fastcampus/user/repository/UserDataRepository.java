package com.example.fastcampus.user.repository;

import com.example.fastcampus.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDataRepository extends JpaRepository<User,Long>, UserCustomRepository {
    Optional<User> findByName(String name);
}
