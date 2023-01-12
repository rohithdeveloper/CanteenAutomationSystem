package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.dto.OrderDto;



public interface IOrderService {
	List<OrderDto> getAllOrders();
	OrderDto getOrder(long orderId);
	OrderDto saveOrder(OrderDto order);
	OrderDto updateOrder(Long orderId,OrderDto order);
	void deleteOrder(Long orderId);
}
