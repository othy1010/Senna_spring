package com.senna.backend.service;

import com.senna.backend.domain.User;

import java.util.Optional;

public interface UserService extends GenericService<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> checkCredentials(String email, String password);
    String getUserType(Long user_id);
}