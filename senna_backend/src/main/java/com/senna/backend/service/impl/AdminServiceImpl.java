package com.senna.backend.service.impl;

import java.util.List;
import com.senna.backend.domain.Admin;

public interface AdminServiceImpl {

   public List<Admin> findAll();

   public Admin findByAdminId(Long adminId);

   public Admin findByEmail(String email);

   public Admin findByUsername(String username);

   public Admin findByToken(String token);

   public Admin saveAdmin(Admin admin);

   public Admin updateAdmin(Long adminId, Admin admin);

   public void deleteAdmin(Long adminId);

}
