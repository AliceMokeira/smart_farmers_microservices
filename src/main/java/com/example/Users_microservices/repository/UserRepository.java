package com.example.Users_microservices.repository;

import com.example.Users_microservices.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity,Long> {
}
