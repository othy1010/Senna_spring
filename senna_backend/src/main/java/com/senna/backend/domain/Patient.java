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
   @SequenceGenerator(name = "patientSequence", sequenceName = "patientSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientSequence")
   @Column(name = "patientId", updatable = false)
   private Long patientId;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "userId")
   private User user;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Patient patient = (Patient) o;
      return patientId != null && Objects.equals(patientId, patient.patientId);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
