package com.senna.backend.service;

import java.util.List;

import com.senna.backend.domain.Composant;

public interface ComposantService {

   Composant saveComposant(Composant composant);

   Composant findByComposantId(Long composantId);

   List<Composant> findAll();

   void deleteComposant(Long composantId);

   Composant updateComposant(Long composantId, Composant composant);

}