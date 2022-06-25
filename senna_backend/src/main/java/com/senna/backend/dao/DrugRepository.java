package com.senna.backend.dao;

import java.util.List;

import com.senna.backend.domain.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {

   List<Drug> findAll();

   Drug findByDrugId(Long drugId);

   Drug findByDrugNameLike(String drugName);

   List<Drug> findAllByDrugUsageLike(String drugUsage);

   List<Drug> findAllByDrugSupplierId(Long drugSupplierId);

}
