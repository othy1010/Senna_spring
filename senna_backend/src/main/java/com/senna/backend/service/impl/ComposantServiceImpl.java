package com.senna.backend.service.impl;

import java.util.List;

import com.senna.backend.domain.Composant;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senna.backend.dao.ComposantRepository;
import com.senna.backend.service.ComposantService;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class ComposantServiceImpl implements ComposantService {
   @Autowired
   private ComposantRepository composantRepository;

   @Override
   @PostMapping("composants")
   public Composant saveComposant(@RequestBody Composant composant) {

      return composantRepository.save(composant);
   }

   @Override
   @GetMapping("composants/composantId/{composantId}")
   public Composant findByComposantId(@PathVariable Long composantId) {

      return composantRepository.findByComposantId(composantId);
   }

   @Override
   @DeleteMapping("composants/composantId/{composantId}")
   public void deleteComposant(@PathVariable Long composantId) {
      composantRepository.deleteById(composantId);

   }

   @Override
   @PutMapping("composants/composantId/{composantId}")
   public Composant updateComposant(@PathVariable Long composantId, @RequestBody Composant composant) {
      Composant composantUpdated = composantRepository.findByComposantId(composantId);

      composantUpdated.setComposantName(composant.getComposantName());

      composantRepository.save(composantUpdated);
      return composantUpdated;
   }

   @Override
   @GetMapping("composants")
   public List<Composant> findAll() {
      return composantRepository.findAll();

   }

}
