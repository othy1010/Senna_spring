package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

   List<Patient> findAll();

   Patient findByPatientId(Long patientId);

}
