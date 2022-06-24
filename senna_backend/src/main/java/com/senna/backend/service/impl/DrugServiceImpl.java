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
import com.senna.backend.dao.DrugRepository;
import com.senna.backend.dao.SupplierRepository;
import com.senna.backend.domain.Category;
import com.senna.backend.domain.Drug;
import com.senna.backend.domain.Supplier;
import com.senna.backend.service.CategoryService;
import com.senna.backend.service.DrugService;
import com.senna.backend.service.SupplierService;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class DrugServiceImpl implements DrugService {
   @Autowired
   private DrugRepository drugRepository;

   @Override
   @PostMapping("drugs")
   public Drug saveDrug(@RequestBody Drug drug) {
      return drugRepository.save(drug);

   }

   @Override
   @GetMapping("drugs/drugId/{drugId}")
   public Drug findByDrugId(@PathVariable Long drugId) {
      return drugRepository.findByDrugId(drugId);

   }

   @Override
   @PutMapping("drugs/drugId/{drugId}")
   public Drug updateDrug(@PathVariable Long drugId, @RequestBody Drug drug) {
      Drug drugUpdated = drugRepository.findByDrugId(drugId);
      // TODO : update drug
      // drugUpdated.setdrugname(drug.getdrugname());
      // drugUpdated.setFirstName(drug.getFirstName());
      // drugUpdated.setSecondName(drug.getSecondName());

      drugRepository.save(drugUpdated);
      return drugUpdated;
   }

   @Override
   @DeleteMapping("drugs/drugId/{drugId}")
   public void deleteDrug(@PathVariable Long drugId) {
      drugRepository.deleteById(drugId);

   }

   @Override
   @GetMapping("drugs/drugUsage/{drugUsage}")
   public List<Drug> findAllByDrugUsageLike(@PathVariable String drugUsage) {
      return drugRepository.findAllByDrugUsageLike(drugUsage);

   }

   @Override
   @GetMapping("drugs/drugName/{drugName}")
   public Drug findByDrugNameLike(@PathVariable String drugName) {
      return drugRepository.findByDrugNameLike(drugName);

   }

   @Override
   @GetMapping("drugs/drugSupplierId/{drugSupplierId}")
   public List<Drug> findAllByDrugSupplierId(@PathVariable Long drugSupplierId) {
      return drugRepository.findAllByDrugSupplierId(drugSupplierId);

   }

   @Override
   @GetMapping("drugs")
   public List<Drug> findAll() {
      return drugRepository.findAll();

   }

}
