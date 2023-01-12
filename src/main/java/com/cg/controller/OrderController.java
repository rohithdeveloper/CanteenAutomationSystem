package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dto.OrderDto;
import com.cg.service.IOrderService;
@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
	Log LOGGER = LogFactory.getFactory().getLog(OrderController.class);
 @Autowired
	IOrderService service;
 @GetMapping("/getorders")
	public List<OrderDto> getAllOrders() {
	 LOGGER.info("OrderController::getAllOrder::Entered");
		List<OrderDto> orders =	service.getAllOrders();	
		 LOGGER.info("OrderController::getAllOrder::Exits");
		return orders;	
	}
 @GetMapping("/getOrderById/{orderId}")
 public OrderDto getOrderById(@PathVariable("orderId") long orderId)
 {
	 LOGGER.info("OrderController::getOrderById::Entered");
	OrderDto order=service.getOrder(orderId);
	 LOGGER.info("OrderController::getOrderById::Exits");
	 return  order;	 
 }
 @Validated
 @PostMapping("/save/order")
	public OrderDto saveOrder(@RequestBody  @Valid OrderDto order) {
	 LOGGER.info("OrderController::saveorder::Entered");
		
		OrderDto dto = service.saveOrder(order)	;
		
		 LOGGER.info("OrderController::save::Exit");
		return dto;
	}
 @PutMapping("/updateorder/{orderId}")
	public OrderDto updateOrder(@PathVariable Long orderId,@RequestBody OrderDto order) {
	 LOGGER.info("OrderController::UpdateOrder::Entered");
		OrderDto orderDto =  service.updateOrder(orderId,order);
	 LOGGER.info("OrderController::updateOrder::Exits");
		return orderDto;
		
	}
 @DeleteMapping("/delete/order/{orderId}")
	public String deleteOrder(@PathVariable("orderId") long orderId) {
	 LOGGER.info("OrderController::deleteOrder::Entered");
		service.deleteOrder(orderId);
	 LOGGER.info("OrderController::deleteOrder::Entered");
		return "Successfully Deleted Order";
		
	}
 

}
