package com.senna.backend.service.impl;

import com.senna.backend.dao.CategoryRepository;
import com.senna.backend.dto.CategoryDTO;
import com.senna.backend.mapper.CategoryMapper;
import com.senna.backend.service.CategoryService;
import com.senna.backend.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category entity) {
        return repository.save(entity);
    }

    @Override
    public List<Category> save(List<Category> entities) {
        return (List<Category>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        Page<Category> entityPage = repository.findAll(pageable);
        List<Category> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Category update(Category entity, Long id) {
        Optional<Category> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}