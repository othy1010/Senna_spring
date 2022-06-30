package com.senna.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "drug")
public class Drug {
   @Id
   @SequenceGenerator(name = "drugSequence", sequenceName = "drugSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drugSequence")
   @Column(name = "drugId", updatable = false)
   private Long drugId;

   @Column(name = "drugName")
   private String drugName;

   @Column(name = "drugDescription", columnDefinition = "text")
   private String drugDescription;

   @Column(name = "drugPrice")
   private Double drugPrice;

   @Column(name = "drugQuantity")
   private Integer drugQuantity;

   @Column(name = "drugCreatedAt")
   private LocalDateTime drugCreatedAt;

   @Column(name = "drugStock")
   private Integer drugStock;

   @Column(name = "needPrescription")
   private Boolean needPrescription;

   @Column(name = "drugCategoryId")
   private Long drugCategoryId;

   @Column(name = "drugSupplierId")
   private Long drugSupplierId;

   @Column(name = "drugUsage", columnDefinition = "text")
   private String drugUsage;

   @Column(name = "drugWarnings", columnDefinition = "text")
   private String drugWarnings;

   @Column(name = "drugSideEffects", columnDefinition = "text")
   private String drugSideEffects;

   // @Fetch(value = FetchMode.SUBSELECT)
   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   // @JoinColumn(name = "composantId")
   // private List<Composant> components = new ArrayList<Composant>();

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Drug drug = (Drug) o;
      return Objects.equals(drugId, drug.drugId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(drugId);
   }
}
