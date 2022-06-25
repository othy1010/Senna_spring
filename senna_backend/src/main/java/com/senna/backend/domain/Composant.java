package com.senna.backend.domain;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "composant")

public class Composant {
   @Id
   @SequenceGenerator(name = "composantSequence", sequenceName = "composantSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "composantSequence")
   @Column(name = "composantId", updatable = false)
   private Long composantId;

   @Column(name = "composantName")
   private String composantName;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Composant composant = (Composant) o;
      return composantId != null &&
            Objects.equals(composantId, composant.composantId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(composantId);
   }
}