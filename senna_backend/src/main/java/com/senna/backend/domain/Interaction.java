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
@Entity(name = "interaction")

// class interaction{
// - Long interactionId
// - String interactionName
// - String interactionDescription
// - Dict interactionTypeMedicine
// }
public class Interaction {
   @Id
   @SequenceGenerator(name = "interactionSequence", sequenceName = "interactionSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interactionSequence")
   @Column(name = "interactionId", updatable = false)
   private Long interactionId;

   @Column(name = "interactionName")
   private String interactionName;

   @Column(name = "interactionDescription")
   private String interactionDescription;

   @Column(name = "interactionTypeMedicine")
   private String interactionTypeMedicine;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Interaction interaction = (Interaction) o;
      return interactionId != null &&
            Objects.equals(interactionId, interaction.interactionId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(interactionId);
   }
}
