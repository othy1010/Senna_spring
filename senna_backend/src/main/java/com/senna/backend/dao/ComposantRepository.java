package com.senna.backend.dao;

import java.util.List;

import com.senna.backend.domain.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepository extends JpaRepository<Composant, Long> {

   List<Composant> findAll();

   Composant findByComposantId(Long composantId);

}
