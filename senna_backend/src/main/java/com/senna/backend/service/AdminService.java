package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Admin;

public interface AdminService {

   Admin saveAdmin(Admin admin);

   Admin findByAdminId(Long adminId);

   Admin updateAdmin(Long adminId, Admin admin);

   // Admin findBybidID(long bidId);

   void deleteAdmin(Long adminId);

   List<Admin> findAll();
   // Admin findByItemId(long itemId);

}
