package com.senna.backend.service;

import java.util.List;
import com.senna.backend.domain.Order;

public interface OrderService {

   Order saveOrder(Order order);

   Order findByOrderId(Long orderId);

   List<Order> findAllByPatientId(Long patientId);

   Order updateOrder(Long orderId, Order order);

   void deleteOrder(Long orderId);

   List<Order> findAll();

}
