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
@Entity(name = "doctor")
public class Doctor {
   @Id
   @SequenceGenerator(name = "doctorSequence", sequenceName = "doctorSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctorSequence")
   @Column(name = "doctorId", updatable = false)
   private Long doctorId;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "userId")
   private User user;

   @Column(name = "isActive", nullable = false, columnDefinition = "BOOLEAN")
   private Boolean isActive;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Doctor doctor = (Doctor) o;
      return doctorId != null && Objects.equals(doctorId, doctor.doctorId);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
