package com.senna.backend.dao;

import com.senna.backend.domain.Drug;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends PagingAndSortingRepository<Drug, Long> {
}