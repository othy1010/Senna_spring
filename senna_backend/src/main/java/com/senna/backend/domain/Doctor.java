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
   @SequenceGenerator(name = "doctor_sequence", sequenceName = "doctor_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_sequence")
   @Column(name = "doctor_id", updatable = false)
   private Long doctor_id;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private User user;

   @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN")
   private Boolean is_active;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Doctor doctor = (Doctor) o;
      return doctor_id != null && Objects.equals(doctor_id, doctor.doctor_id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
