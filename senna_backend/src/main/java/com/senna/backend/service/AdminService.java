package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Admin;

public interface AdminService {

   Admin saveAdmin(Admin admin);

   Admin findByEmail(String email);

   Admin findByAdminId(Long idA);

   List<Admin> findByUsername(String username);

   Admin findByToken(String token);

   Admin updateAdmin(Long idA, Admin admin);

   // Admin findBybidID(long bidId);

   // Admin findByItemId(long itemId);

}
