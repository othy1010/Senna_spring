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
   @SequenceGenerator(name = "adminSequence", sequenceName = "adminSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSequence")
   @Column(name = "adminId", updatable = false)
   private Long adminId;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "userId")
   private User user;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Admin admin = (Admin) o;
      return adminId != null && Objects.equals(adminId, admin.adminId);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
