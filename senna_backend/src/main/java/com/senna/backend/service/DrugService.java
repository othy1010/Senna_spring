package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Drug;

public interface DrugService {

   Drug saveDrug(Drug drug);

   Drug findByDrugId(Long drugId);

   Drug updateDrug(Long drugId, Drug drug);

   void deleteDrug(Long drugId);

   List<Drug> findAll();

   Drug findByDrugNameLike(String drugName);

   List<Drug> findAllByDrugUsageLike(String drugUsage);

   List<Drug> findAllByDrugSupplierId(Long drugSupplierId);

}
