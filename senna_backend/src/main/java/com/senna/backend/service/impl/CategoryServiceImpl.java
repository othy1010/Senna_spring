package com.senna.backend.service.impl;

import java.util.List;

import com.senna.backend.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senna.backend.dao.CategoryRepository;
import com.senna.backend.service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class CategoryServiceImpl implements CategoryService {
   @Autowired
   private CategoryRepository categoryRepository;

   @Override
   @PostMapping("categories")
   public Category saveCategory(@RequestBody Category category) {
      return categoryRepository.save(category);

   }

   @Override
   @GetMapping("categories/categorieId/{categorieId}")
   public Category findByCategoryId(@PathVariable Long categoryId) {
      return categoryRepository.findByCategoryId(categoryId);

   }

   @Override
   @PutMapping("categories/categorieId/{categorieId}")
   public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
      Category categoryUpdated = categoryRepository.findByCategoryId(categoryId);

      categoryUpdated.setCategoryName(category.getCategoryName());
      categoryUpdated.setCategoryDescription(category.getCategoryDescription());

      categoryRepository.save(categoryUpdated);
      return categoryUpdated;
   }

   @Override
   @DeleteMapping("categories/categorieId/{categorieId}")
   public void deleteCategory(@PathVariable Long categoryId) {
      categoryRepository.deleteById(categoryId);

   }

   @Override
   @GetMapping("categories")
   public List<Category> findAll() {
      return categoryRepository.findAll();

   }

}
