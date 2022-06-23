package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByUserId(Long userId);

    User findByCountry(String country);

    User findByToken(String token);

    List<User> findAllByIsConfirmed(Boolean isConfirmed);

    List<User> findByUsername(String username);

    List<User> findAllByRole(String role);

    User findByEmail(String email);

}
