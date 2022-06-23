package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {

}
