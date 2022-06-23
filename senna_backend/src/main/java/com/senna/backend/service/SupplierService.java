package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Supplier;

public interface SupplierService {

   Supplier saveSupplier(Supplier supplier);

   Supplier findBySupplierId(Long supplierId);

   Supplier updateSupplier(Long supplierId, Supplier supplier);

   void deleteSupplier(Long supplierId);

   List<Supplier> findAll();

}
