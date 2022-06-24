package com.senna.backend.service.impl;

import java.util.List;

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

import com.senna.backend.dao.CategoryRepository;
import com.senna.backend.dao.CertificationRepository;
import com.senna.backend.dao.SupplierRepository;
import com.senna.backend.domain.Category;
import com.senna.backend.domain.Certification;
import com.senna.backend.domain.Supplier;
import com.senna.backend.service.CategoryService;
import com.senna.backend.service.CertificationService;
import com.senna.backend.service.SupplierService;

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
      // TODO Auto-generated method stub
      Certification certificationUpdated = certificationRepository.findByCertificationId(certificationId);
      // TODO : update certification
      // certificationUpdated.setcertificationname(certification.getcertificationname());
      // certificationUpdated.setFirstName(certification.getFirstName());
      // certificationUpdated.setSecondName(certification.getSecondName());

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
