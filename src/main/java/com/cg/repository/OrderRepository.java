package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	

}
