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
@Entity(name = "supplier")

public class Supplier {
   @Id
   @SequenceGenerator(name = "supplier_sequence", sequenceName = "supplier_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_sequence")
   @Column(name = "supplier_id", updatable = false)
   private Long supplier_id;

   @Column(name = "supplier_name")
   private String supplier_name;

   @Column(name = "supplier_description")
   private String supplier_description;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Supplier supplier = (Supplier) o;
      return supplier_id != null &&
            Objects.equals(supplier_id, supplier.supplier_id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(supplier_id);
   }
}