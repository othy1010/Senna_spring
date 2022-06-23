package com.senna.backend.service.impl;

import com.senna.backend.dao.CertificationRepository;
import com.senna.backend.domain.Certification;
import com.senna.backend.dto.DayDTO;
import com.senna.backend.mapper.DayMapper;
import com.senna.backend.service.CertificationService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CertificationServiceImpl implements CertificationService {
    private final CertificationRepository repository;

    public CertificationServiceImpl(CertificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Certification save(Certification entity) {
        return repository.save(entity);
    }

    @Override
    public List<Certification> save(List<Certification> entities) {
        return (List<Certification>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Optional<Certification> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Certification> findAll() {
        return (List<Certification>) repository.findAll();
    }

    @Override
    public Page<Certification> findAll(Pageable pageable) {
        Page<Certification> entityPage = repository.findAll(pageable);
        List<Certification> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Certification update(Certification entity, Long id) {
        Optional<Certification> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    // @Override
    // public Day save(Day entity) {
    // return repository.save(entity);
    // }

    // @Override
    // public List<Day> save(List<Day> entities) {
    // return (List<Day>) repository.saveAll(entities);
    // }

    // @Override
    // public void deleteById(Long id) {
    // repository.deleteById(id);
    // }

    // @Override
    // public Optional<Day> findById(Long id) {
    // return repository.findById(id);
    // }

    // @Override
    // public List<Day> findAll() {
    // return (List<Day>) repository.findAll();
    // }

    // @Override
    // public Page<Day> findAll(Pageable pageable) {
    // Page<Day> entityPage = repository.findAll(pageable);
    // List<Day> entities = entityPage.getContent();
    // return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    // }

    // @Override
    // public Day update(Day entity, Long id) {
    // Optional<Day> optional = findById(id);
    // if (optional.isPresent()) {
    // return save(entity);
    // }
    // return null;
    // }
}