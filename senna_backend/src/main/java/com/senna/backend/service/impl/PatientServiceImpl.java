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
import com.senna.backend.dao.PatientRepository;
import com.senna.backend.dao.SupplierRepository;
import com.senna.backend.domain.Category;
import com.senna.backend.domain.Patient;
import com.senna.backend.domain.Supplier;
import com.senna.backend.service.CategoryService;
import com.senna.backend.service.PatientService;
import com.senna.backend.service.SupplierService;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(@RequestBody Patient patient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Patient findByPatientId(@PathVariable Long patientId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Patient updatePatient(@PathVariable Long patientId, @RequestBody Patient patient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletePatient(@PathVariable Long patientId) {
        // TODO Auto-generated method stub

    }

}
