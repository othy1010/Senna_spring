package com.senna.backend.service.impl;

import java.util.List;

import com.senna.backend.domain.Certification;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senna.backend.dao.CertificationRepository;
import com.senna.backend.service.CertificationService;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class CertificationServiceImpl implements CertificationService {
   @Autowired
   private CertificationRepository certificationRepository;

   @Override
   @PostMapping("certifications")
   public Certification saveCertification(@RequestBody Certification certification) {
      return certificationRepository.save(certification);

   }

   @Override
   @GetMapping("certifications/certificationId/{certificationId}")
   public Certification findByCertificationId(@PathVariable Long certificationId) {
      return certificationRepository.findByCertificationId(certificationId);

   }

   @Override
   @PutMapping("certifications/certificationId/{certificationId}")
   public Certification updateCertification(@PathVariable Long certificationId,
         @RequestBody Certification certification) {
      Certification certificationUpdated = certificationRepository.findByCertificationId(certificationId);

      certificationUpdated.setDoctorId(certification.getDoctorId());
      certificationUpdated.setCertificationName(certification.getCertificationName());
      certificationUpdated.setCertificationNumber(certification.getCertificationNumber());
      certificationUpdated.setCertificationDate(certification.getCertificationDate());

      certificationRepository.save(certificationUpdated);
      return certificationUpdated;
   }

   @Override
   @GetMapping("certifications")
   public List<Certification> findAll() {
      return certificationRepository.findAll();

   }

   @Override
   @DeleteMapping("certifications/certificationId/{certificationId}")
   public void deleteCertification(@PathVariable Long certificationId) {
      certificationRepository.deleteById(certificationId);

   }

}
