package com.reading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reading.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
