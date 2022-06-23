package com.senna.backend.service.impl;

import com.senna.backend.dao.ComposantRepository;
import com.senna.backend.domain.Composant;
import com.senna.backend.dto.DetailDTO;
import com.senna.backend.mapper.DetailMapper;
import com.senna.backend.service.ComposantService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComposantServiceImpl implements ComposantService {
    private final ComposantRepository repository;

    @Override
    public Composant save(Composant entity) {
        return repository.save(entity);
    }

    @Override
    public List<Composant> save(List<Composant> entities) {
        // return repository.save(entity);
    }

    @Override
    public Composant update(Composant entity, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
        
    }

    @Override
    public Optional<Composant> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Composant> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Composant> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }




    
    // public ComposantServiceImpl(DetailRepository repository) {
    //     this.repository = repository;
    // }

    // @Override
    // public Detail save(Detail entity) {
        // return repository.save(entity);
    // }

    // @Override
    // public List<Detail> save(List<Detail> entities) {
    //     return (List<Detail>) repository.saveAll(entities);
    // }

    // @Override
    // public void deleteById(Long id) {
    //     repository.deleteById(id);
    // }

    // @Override
    // public Optional<Detail> findById(Long id) {
    //     return repository.findById(id);
    // }

    // @Override
    // public List<Detail> findAll() {
    //     return (List<Detail>) repository.findAll();
    // }

    // @Override
    // public Page<Detail> findAll(Pageable pageable) {
    //     Page<Detail> entityPage = repository.findAll(pageable);
    //     List<Detail> entities = entityPage.getContent();
    //     return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    // }

    // @Override
    // public Detail update(Detail entity, Long id) {
    //     Optional<Detail> optional = findById(id);
    //     if (optional.isPresent()) {
    //         return save(entity);
    //     }
    //     return null;
    // }

}