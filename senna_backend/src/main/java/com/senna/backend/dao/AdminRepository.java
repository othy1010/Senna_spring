package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

   List<Admin> findAll();

   Admin findByAdminId(Long adminId);

}
