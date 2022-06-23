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
// - Long interaction_id
// - String interaction_name
// - String interaction_description
// - Dict interaction_type_medicine
// }
public class Interaction {
   @Id
   @SequenceGenerator(name = "interaction_sequence", sequenceName = "interaction_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interaction_sequence")
   @Column(name = "interaction_id", updatable = false)
   private Long interaction_id;

   @Column(name = "interaction_name")
   private String interaction_name;

   @Column(name = "interaction_description")
   private String interaction_description;

   @Column(name = "interaction_type_medicine")
   private String interaction_type_medicine;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Interaction interaction = (Interaction) o;
      return interaction_id != null &&
            Objects.equals(interaction_id, interaction.interaction_id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(interaction_id);
   }
}
