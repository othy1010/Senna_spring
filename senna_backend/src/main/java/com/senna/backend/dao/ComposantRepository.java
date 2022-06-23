package com.senna.backend.dao;

import com.senna.backend.domain.Composant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposantRepository extends PagingAndSortingRepository<Composant, Long> {
}