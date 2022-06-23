package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.User;

public interface UserService {

   User saveUser(User user);

   User findByEmail(String email);

   User findByUserId(Long idU);

   List<User> findByUsername(String username);

   User findByToken(String token);

   User updateUser(Long idU, User user);

   // User findBybidID(long bidId);

   // User findByItemId(long itemId);

   void deleteUser(Long idU);

}
