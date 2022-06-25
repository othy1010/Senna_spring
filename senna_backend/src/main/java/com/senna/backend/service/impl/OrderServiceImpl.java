package com.senna.backend.service.impl;

import java.util.List;

import com.senna.backend.domain.Order;
import com.senna.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senna.backend.dao.OrderRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@Service
@Transactional
@RestController
@RequestMapping("api/")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @PostMapping("orders")
    public Order saveOrder(@RequestBody Order order) {

        return orderRepository.save(order);
    }

    @Override
    @GetMapping("orders/orderId/{orderId}")
    public Order findByOrderId(@PathVariable Long orderId) {

        return orderRepository.findByOrderId(orderId);
    }

    @Override
    @GetMapping("orders/patientId/{patientId}")
    public List<Order> findAllByPatientId(@PathVariable Long patientId) {

        return orderRepository.findAllByPatientId(patientId);
    }

    @Override
    @PutMapping("orders/orderId/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        Order orderUpdated = orderRepository.findByOrderId(orderId);
        // TODO : update order
        // orderUpdated.setordername(order.getordername());
        // orderUpdated.setFirstName(order.getFirstName());
        // orderUpdated.setSecondName(order.getSecondName());

        orderUpdated.setOrderId(order.getOrderId());
        orderUpdated.setPatientId(order.getPatientId());
        orderUpdated.setTotalPrice(order.getTotalPrice());
        orderUpdated.setOrderTrackNumber(order.getOrderTrackNumber());
        orderUpdated.setOrderDate(order.getOrderDate());
        orderUpdated.setOrderStatus(order.getOrderStatus());

        orderRepository.save(orderUpdated);
        return orderUpdated;
    }

    @Override
    @DeleteMapping("orders/orderId/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        // TODO Auto-generated method stub
        orderRepository.deleteById(orderId);

    }

    @Override
    @GetMapping("orders")
    public List<Order> findAll() {
        return orderRepository.findAll();

    }

}
