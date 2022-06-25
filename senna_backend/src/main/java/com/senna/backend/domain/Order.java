package com.senna.backend.domain;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "orders")
public class Order {
   @Id
   @SequenceGenerator(name = "orderSequence", sequenceName = "orderSequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSequence")
   @Column(name = "orderId", updatable = false)
   private Long orderId;

   @Column(name = "patientId", updatable = false)
   private Long patientId;

   @Column(name = "totalPrice", nullable = false, columnDefinition = "DECIMAL(10,2)")
   private Double totalPrice;

   @Column(name = "orderTrackNumber", nullable = false, columnDefinition = "TEXT")
   private String orderTrackNumber;

   @Column(name = "orderDate", nullable = false, columnDefinition = "TIMESTAMP")
   private LocalDateTime orderDate;

   // @OneToMany
   // @JoinTable(name = "drug", joinColumns = @JoinColumn(name = "orderId",
   // referencedColumnName = "orderId"), inverseJoinColumns = @JoinColumn(name =
   // "drugId", referencedColumnName = "drugId"))
   // private List<Drug> drugs;

   @Column(name = "orderStatus", nullable = false, columnDefinition = "TEXT")
   private String orderStatus;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Order order = (Order) o;
      return orderId != null &&
            Objects.equals(orderId, order.orderId);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}

// @OneToMany
// @JoinTable(name="detail", joinColumns = @JoinColumn(name = "orderId",
// referencedColumnName = "orderId"), inverseJoinColumns = @JoinColumn(name =
// "detailId", referencedColumnName = "detailId"))
// private List<Detail> details;

// @OneToMany
// @JoinTable(name="job", joinColumns = @JoinColumn(name = "orderId",
// referencedColumnName = "orderId"), inverseJoinColumns = @JoinColumn(name =
// "jobId", referencedColumnName = "jobId"))
// private List<Job> jobs;