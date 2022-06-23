package com.senna.backend.dao;

import com.senna.backend.domain.Doctor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {
}