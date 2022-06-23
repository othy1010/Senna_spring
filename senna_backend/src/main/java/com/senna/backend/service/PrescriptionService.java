package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Prescription;

public interface PrescriptionService {

   Prescription savePrescription(Prescription prescription);

   Prescription findByPrescriptionId(Long prescriptionId);

   List<Prescription> findAllByPatientId(Long UserId);

   List<Prescription> findAllByDoctorId(Long DoctorId);

   Prescription updatePrescription(Long prescriptionId, Prescription prescription);

   void deletePrescription(Long prescriptionId);

   List<Prescription> findAll();
}
