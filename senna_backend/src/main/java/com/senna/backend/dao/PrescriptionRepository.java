package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
