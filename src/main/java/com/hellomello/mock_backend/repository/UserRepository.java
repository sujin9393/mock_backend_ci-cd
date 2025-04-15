package com.hellomello.mock_backend.repository;

import com.hellomello.mock_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}