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
@Entity(name = "category")

public class Category {
   @Id
   @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
   @Column(name = "category_id", updatable = false)
   private Long category_id;

   @Column(name = "category_name")
   private String category_name;

   @Column(name = "category_description")
   private String category_description;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Category category = (Category) o;
      return category_id != null &&
            Objects.equals(category_id, category.category_id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(category_id);
   }
}
