package com.senna.backend.dao;

import com.senna.backend.domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

   Category findByCategoryId(Long categoryId);
}
