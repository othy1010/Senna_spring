package com.senna.backend.service;

import com.senna.backend.domain.User;

public interface UserService {

    User saveUser(User user);

    User findByUserId(Long idU);

    User updateUser(Long idU, User user);

    // User findBybidID(long bidId);

    // User findByItemId(long itemId);

    void deleteUser(Long idU);

}
