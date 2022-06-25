package com.senna.backend.domain;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "category")

public class Category {
   @Id
   @SequenceGenerator(name = "categorySequence", sequenceName = "categorySequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequence")
   @Column(name = "categoryId", updatable = false)
   private Long categoryId;

   @Column(name = "categoryName")
   private String categoryName;

   @Column(name = "categoryDescription")
   private String categoryDescription;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Category category = (Category) o;
      return categoryId != null &&
            Objects.equals(categoryId, category.categoryId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(categoryId);
   }
}
