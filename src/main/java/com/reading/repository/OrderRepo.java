package com.reading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reading.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
