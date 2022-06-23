package com.senna.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "certification")
public class Certification {
   @Id
   @SequenceGenerator(name = "certification_sequence", sequenceName = "certification_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certification_sequence")
   @Column(name = "certification_id", updatable = false)
   private Long certification_id;

   @Column(name = "doctor_id", updatable = false)
   private Long doctor_id;

   @Column(name = "certification_name", nullable = false, columnDefinition = "TEXT")
   private String certification_name;

   @Column(name = "certification_number", nullable = false)
   private Long certification_number;

   @Column(name = "certification_date", nullable = false, columnDefinition = "TIMESTAMP")
   private LocalDateTime certification_date;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Certification certification = (Certification) o;
      return certification_id != null && Objects.equals(certification_id, certification.certification_id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}