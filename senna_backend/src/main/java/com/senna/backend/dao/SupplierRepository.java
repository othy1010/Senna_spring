package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
