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
@Entity(name = "admin")
public class Admin {
   @Id
   @SequenceGenerator(name = "admin_sequence", sequenceName = "admin_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_sequence")
   @Column(name = "admin_id", updatable = false)
   private Long admin_id;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private User user;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Admin admin = (Admin) o;
      return admin_id != null && Objects.equals(admin_id, admin.admin_id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
