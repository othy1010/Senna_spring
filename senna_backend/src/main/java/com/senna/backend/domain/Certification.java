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
   @SequenceGenerator(name = "certificationSequence", sequenceName = "certificationSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificationSequence")
   @Column(name = "certificationId", updatable = false)
   private Long certificationId;

   @Column(name = "doctorId", updatable = false)
   private Long doctorId;

   @Column(name = "certificationName", nullable = false, columnDefinition = "TEXT")
   private String certificationName;

   @Column(name = "certificationNumber", nullable = false)
   private Long certificationNumber;

   @Column(name = "certificationDate", nullable = false, columnDefinition = "TIMESTAMP")
   private LocalDateTime certificationDate;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Certification certification = (Certification) o;
      return certificationId != null && Objects.equals(certificationId, certification.certificationId);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}