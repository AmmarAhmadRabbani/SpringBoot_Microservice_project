package com.te.customerservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.customerservices.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
