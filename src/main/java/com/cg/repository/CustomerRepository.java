package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.CustomerDto;
import com.cg.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	CustomerDto findByCustomerId(Long customerId); 

}
