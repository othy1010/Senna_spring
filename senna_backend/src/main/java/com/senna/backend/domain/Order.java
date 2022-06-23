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
@Entity(name = "order")
public class Order {
   @Id
   @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
   @Column(name = "order_id", updatable = false)
   private Long order_id;

   @Column(name = "patient_id", updatable = false)
   private Long patient_id;

   @Column(name = "total_price", nullable = false, columnDefinition = "DECIMAL(10,2)")
   private Double total_price;

   @Column(name = "order_track_number", nullable = false, columnDefinition = "TEXT")
   private String order_track_number;

   @Column(name = "order_date", nullable = false, columnDefinition = "TIMESTAMP")
   private LocalDateTime order_date;

   @OneToMany
   @JoinTable(name = "drug", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id"), inverseJoinColumns = @JoinColumn(name = "drug_id", referencedColumnName = "drug_id"))
   private List<Drug> drugs;

   @Column(name = "order_status", nullable = false, columnDefinition = "TEXT")
   private String order_status;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Order order = (Order) o;
      return order_id != null && Objects.equals(order_id, order.order_id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}

// @OneToMany
// @JoinTable(name="detail", joinColumns = @JoinColumn(name = "order_id",
// referencedColumnName = "order_id"), inverseJoinColumns = @JoinColumn(name =
// "detail_id", referencedColumnName = "detail_id"))
// private List<Detail> details;

// @OneToMany
// @JoinTable(name="job", joinColumns = @JoinColumn(name = "order_id",
// referencedColumnName = "order_id"), inverseJoinColumns = @JoinColumn(name =
// "job_id", referencedColumnName = "job_id"))
// private List<Job> jobs;