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
@Entity(name = "drug")
public class Drug {
   @Id
   @SequenceGenerator(name = "drug_sequence", sequenceName = "drug_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drug_sequence")
   @Column(name = "drug_id", updatable = false)
   private Long drug_id;

   @Column(name = "drug_name")
   private String drug_name;

   @Column(name = "drug_description")
   private String drug_description;

   @Column(name = "drug_price")
   private Double drug_price;

   @Column(name = "drug_quantity")
   private Integer drug_quantity;

   @Column(name = "drug_created_at")
   private LocalDateTime drug_created_at;

   @Column(name = "drug_stock")
   private Integer drug_stock;

   @Column(name = "need_prescription")
   private Boolean need_prescription;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "category_id")
   private Category drug_category;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "drug_supplier_id")
   private Supplier drug_supplier;

   @Column(name = "drug_usage")
   private String drug_usage;

   @Column(name = "drug_warnings")
   private String drug_warnings;

   @Column(name = "drug_Side_effects")
   private String drug_Side_effects;

   @Column(name = "components")
   private List<Composant> components;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Drug drug = (Drug) o;
      return Objects.equals(drug_id, drug.drug_id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(drug_id);
   }
}
