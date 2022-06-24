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

import com.senna.backend.dao.AdminRepository;
import com.senna.backend.dao.CategoryRepository;
import com.senna.backend.dao.SupplierRepository;
import com.senna.backend.domain.Admin;
import com.senna.backend.domain.Category;
import com.senna.backend.domain.Supplier;
import com.senna.backend.service.AdminService;
import com.senna.backend.service.CategoryService;
import com.senna.backend.service.SupplierService;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class AdminServiceImpl implements AdminService {
   @Autowired
   private AdminRepository adminRepository;

   @Override
   @GetMapping("admins")
   public List<Admin> findAll() {
      return adminRepository.findAll();

   }

   @Override
   @PostMapping("admins")
   public Admin saveAdmin(@RequestBody Admin admin) {
      return adminRepository.save(admin);
   }

   @Override
   @GetMapping("admins/adminId/{adminId}")
   public Admin findByAdminId(@PathVariable Long adminId) {
      return adminRepository.findByAdminId(adminId);
   }

   @Override
   @PutMapping("admins/adminId/{adminId}")
   public Admin updateAdmin(@PathVariable Long adminId, @RequestBody Admin admin) {
      Admin adminUpdated = adminRepository.findByAdminId(adminId);
      // TODO : update admin
      // adminUpdated.setadminname(admin.getadminname());
      // adminUpdated.setFirstName(admin.getFirstName());
      // adminUpdated.setSecondName(admin.getSecondName());

      adminRepository.save(adminUpdated);
      return adminUpdated;
   }

   @Override
   @DeleteMapping("admins/adminId/{adminId}")
   public void deleteAdmin(@PathVariable Long adminId) {
      adminRepository.deleteById(adminId);

   }

}
