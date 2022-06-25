package com.senna.backend.service.impl;

import java.util.List;

import com.senna.backend.domain.Prescription;
import com.senna.backend.service.PrescriptionService;
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

import com.senna.backend.dao.PrescriptionRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @PostMapping("prescriptions")
    public Prescription savePrescription(@RequestBody Prescription prescription) {

        return prescriptionRepository.save(prescription);
    }

    @Override
    @GetMapping("prescriptions/prescriptionId/{prescriptionId}")
    public Prescription findByPrescriptionId(@PathVariable Long prescriptionId) {

        return prescriptionRepository.findByPrescriptionId(prescriptionId);
    }

    @Override
    @GetMapping("prescriptions/patientId/{patientId}")
    public List<Prescription> findAllByPatientId(@PathVariable Long patientId) {

        return prescriptionRepository.findAllByPatientId(patientId);
    }

    @Override
    @GetMapping("prescriptions/doctorId/{doctorId}")
    public List<Prescription> findAllByDoctorId(@PathVariable Long doctorId) {

        return prescriptionRepository.findAllByDoctorId(doctorId);
    }

    @Override
    @PutMapping("prescriptions/prescriptionId/{prescriptionId}")
    public Prescription updatePrescription(@PathVariable Long prescriptionId, @RequestBody Prescription prescription) {

        Prescription prescriptionUpdated = prescriptionRepository.findByPrescriptionId(prescriptionId);

        prescriptionUpdated.setPrescriptionTitle(prescription.getPrescriptionTitle());
        prescriptionUpdated.setPrescriptionDate(prescription.getPrescriptionDate());
        prescriptionUpdated.setPrescriptionDescription(prescription.getPrescriptionDescription());
        prescriptionUpdated.setPrescriptionStatus(prescription.getPrescriptionStatus());
        prescriptionUpdated.setPatientId(prescription.getPatientId());
        prescriptionUpdated.setDoctorId(prescription.getDoctorId());

        prescriptionRepository.save(prescriptionUpdated);
        return prescriptionUpdated;
    }

    @Override
    @DeleteMapping("prescriptions/prescriptionId/{prescriptionId}")
    public void deletePrescription(@PathVariable Long prescriptionId) {
        prescriptionRepository.deleteById(prescriptionId);

    }

    @Override
    @GetMapping("prescriptions")
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

}
