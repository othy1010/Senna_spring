package com.senna.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "composant")

public class Composant {
   @Id
   @SequenceGenerator(name = "composant_sequence", sequenceName = "composant_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "composant_sequence")
   @Column(name = "composant_id", updatable = false)
   private Long composant_id;

   @Column(name = "composant_name")
   private String composant_name;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Composant composant = (Composant) o;
      return composant_id != null &&
            Objects.equals(composant_id, composant.composant_id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(composant_id);
   }
}