package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Patient;

public interface PatientService {

   Patient savePatient(Patient patient);

   Patient findByPatientId(Long patientId);

   Patient updatePatient(Long patientId, Patient patient);

   void deletePatient(Long patientId);

}
