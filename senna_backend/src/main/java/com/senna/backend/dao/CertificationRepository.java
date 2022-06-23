package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

   List<Certification> findAll();

   Certification findByCertificationId(Long certificationId);

}
