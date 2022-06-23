package com.senna.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "patient")
public class Patient {
   @Id
   @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
   @Column(name = "patient_id", updatable = false)
   private Long patient_id;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private User user;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Patient patient = (Patient) o;
      return patient_id != null && Objects.equals(patient_id, patient.patient_id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
