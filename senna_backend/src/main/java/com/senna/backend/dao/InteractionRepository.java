package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {

}
