package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Drug;

public interface DrugService {

   Drug saveDrug(Drug drug);

   Drug findByDrugId(Long drugId);

   Drug updateDrug(Long drugId, Drug drug);

   void deleteDrug(Long drugId);

   List<Drug> findAll();

   List<Drug> findAllByPatientId(Long patientId);

   List<Drug> findAllByDoctorId(Long doctorId);

   List<Drug> findAllBySupplierId(Long supplierId);

   List<Drug> findAllByOrderId(Long orderId);

   List<Drug> findAllByPrescriptionId(Long prescriptionId);

   List<Drug> findAllByDrugName(String drugName);

   List<Drug> findAllByDrugDescription(String drugDescription);

   List<Drug> findAllByDrugPrice(Double drugPrice);

   List<Drug> findAllByDrugQuantity(Integer drugQuantity);

   List<Drug> findAllByDrugExpirationDate(String drugExpirationDate);

   List<Drug> findAllByDrugManufactureDate(String drugManufactureDate);

   List<Drug> findAllByDrugStatus(String drugStatus);

   List<Drug> findAllByDrugType(String drugType);

   List<Drug> findAllByDrugImage(String drugImage);

   List<Drug> findAllByDrugImageContentType(String drugImageContentType);

   List<Drug> findAllByDrugImageFileSize(Integer drugImageFileSize);

}
