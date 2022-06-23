package com.senna.backend.dao;

import java.util.List;
import com.senna.backend.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
