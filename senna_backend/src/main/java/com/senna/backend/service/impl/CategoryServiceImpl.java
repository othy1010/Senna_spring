package com.senna.backend.service.impl;

import java.util.List;
import com.senna.backend.domain.User;

public interface UserService {

   Category saveCategory(Category category);

   Category findByCategoryId(Long categoryId);

   Category updateCategory(Long categoryId, Category category);

}
