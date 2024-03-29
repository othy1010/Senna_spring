package com.senna.backend.service.impl;

import java.util.List;

import com.senna.backend.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senna.backend.dao.SupplierRepository;
import com.senna.backend.service.SupplierService;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class SupplierServiceImpl implements SupplierService {
   @Autowired
   private SupplierRepository supplierRepository;

   @Override
   public Supplier saveSupplier(@RequestBody Supplier supplier) {
      Supplier supplierN = supplierRepository.save(supplier);
      return supplierN;
   }

   @Override
   public Supplier findBySupplierId(@PathVariable Long supplierId) {
      Supplier supplier = supplierRepository.findBySupplierId(supplierId);
      return supplier;
   }

   @Override
   public Supplier updateSupplier(@PathVariable Long supplierId, @RequestBody Supplier supplier) {
      Supplier supplierUpdated = supplierRepository.findBySupplierId(supplierId);

      supplierUpdated.setSupplierName(supplier.getSupplierName());
      supplierUpdated.setSupplierDescription(supplier.getSupplierDescription());

      supplierRepository.save(supplierUpdated);
      return supplierUpdated;
   }

   @Override
   public List<Supplier> findAll() {
      return supplierRepository.findAll();
   }

   @Override
   public void deleteSupplier(@PathVariable Long supplierId) {
      supplierRepository.deleteById(supplierId);

   }
}
