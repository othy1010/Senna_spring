package com.senna.backend.domain;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "supplier")

public class Supplier {
   @Id
   @SequenceGenerator(name = "supplierSequence", sequenceName = "supplierSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplierSequence")
   @Column(name = "supplierId", updatable = false)
   private Long supplierId;

   @Column(name = "supplierName")
   private String supplierName;

   @Column(name = "supplierDescription", columnDefinition = "text")
   private String supplierDescription;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Supplier supplier = (Supplier) o;
      return supplierId != null &&
            Objects.equals(supplierId, supplier.supplierId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(supplierId);
   }
}