package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Category;

public interface CategoryService {

   Category saveCategory(Category category);

   Category findByCategoryId(Long categoryId);

   Category updateCategory(Long categoryId, Category category);

}
