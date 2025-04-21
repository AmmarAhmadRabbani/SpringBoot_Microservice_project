package com.te.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.orderservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
