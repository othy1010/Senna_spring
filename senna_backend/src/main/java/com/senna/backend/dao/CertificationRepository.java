package com.senna.backend.dao;

import com.senna.backend.domain.Certification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends PagingAndSortingRepository<Certification, Long> {
}