package com.cg.canteenAutomationSystem.CanteenAutomationSystem.orderController;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.controller.OrderController;
//import com.cg.cricket.dto.TeamDto;
//import com.cg.cricket.dto.TeamDto;
//import com.cg.cricket.dto.GroundDto;
import com.cg.dto.CustomerDto;
import com.cg.dto.OrderDto;
import com.cg.dto.ProductDto;
import com.cg.entity.Customer;
import com.cg.service.IOrderService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
@InjectMocks
OrderController orderController;
@Mock
IOrderService  iOrderService;
@Test
void getAllOrdersTest() {
	List<OrderDto> orders = createOrdersDtoMockData();		
	when(iOrderService.getAllOrders()).thenReturn(orders);
	List<OrderDto> orderList = orderController.getAllOrders();
	assert(orders.size() == orderList.size());
	
}
private List<OrderDto> createOrdersDtoMockData(){
	List<OrderDto> orders = new ArrayList<>();
	List<ProductDto> product= new ArrayList<>();
	 ProductDto obj=new ProductDto();
	 obj.setPrice(11);
	 obj.setProductName("santooer");
	 obj.setQuantity(500);
	 product.add(obj);
	OrderDto order = new OrderDto();
	order.setStatus("order");
	order.setProduct(product);

	order.setDate(new Date(2022,12, 1));
	orders.add(order);
	return orders;
}
@Test
void getOrderByIdTest() {
	
	long id = 1;
	OrderDto order = createOrderDtoMockData();		
	when( iOrderService.getOrder(id)).thenReturn(order);
	
	OrderDto orderInfo = orderController.getOrderById(id);
	
	assert(order.getOrderId() == orderInfo.getOrderId());
	
}
@Test
void deleteOrderTest() {

	long id = 1;
	
	String msg = "Successfully Deleted Order";
	
	doNothing().when(iOrderService).deleteOrder(id);
	
	String message = orderController.deleteOrder(id);
	
	assert(message.equals(msg));
	
}
@Test
void updateOrdertest() {
long orderId=1;
	OrderDto orderDto = createOrderDtoMockData();	

	when(iOrderService.updateOrder(orderId, orderDto)).thenReturn(orderDto);
	
	OrderDto teamInfo = orderController.updateOrder(orderId, orderDto);
	
	assert(orderDto.getOrderId() == teamInfo.getOrderId());
}
@Test
void saveOrderTest() {

	OrderDto orderDto = createOrderDtoMockData();	

	when(iOrderService.saveOrder(orderDto)).thenReturn(orderDto);
	
	OrderDto orderInfo = orderController.saveOrder(orderDto);
	
	assert(orderDto.getOrderId() ==  orderInfo.getOrderId());
	
}
	

private OrderDto createOrderDtoMockData()
{
	long id=1;
	OrderDto odto=new OrderDto();
	odto.setOrderId(id);
	odto.setStatus("order");
	odto.setDate(new Date(2022, 10, 10));
	
	
	List<ProductDto> product= new ArrayList<>();
	 ProductDto obj=new ProductDto();
	 obj.setPrice(11);
	 obj.setProductName("santooer");
	 obj.setQuantity(500);
	 product.add(obj);
	 odto.setProduct(product);
	return odto;
	
}



}
