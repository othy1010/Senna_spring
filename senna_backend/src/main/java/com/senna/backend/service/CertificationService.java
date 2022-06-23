package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Certification;

public interface CertificationService {

   Certification saveCertification(Certification certification);

   Certification findByCertificationId(Long certificationId);

   Certification updateCertification(Long certificationId, Certification certification);

   List<Certification> findAll();

   void deleteCertification(Long certificationId);

}
