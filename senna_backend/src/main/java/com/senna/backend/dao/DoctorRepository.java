package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

   List<Doctor> findAll();

   Doctor findByDoctorId(Long doctorId);

}
