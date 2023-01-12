package com.cg.canteenAutomationSystem.CanteenAutomationSystem.orderController;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.dto.OrderDto;
import com.cg.dto.ProductDto;
import com.cg.entity.Customer;
import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.repository.OrderRepository;
import com.cg.service.seviceImpl.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
@InjectMocks	
OrderServiceImpl iOrderServiceImpl;
@Mock
OrderRepository repo;
@Test
void getAllOrdersTest() {
	List<Order> orders = createOrdersDtoMockData();		
	when(repo.findAll()).thenReturn(orders);
	List<OrderDto> orderList = iOrderServiceImpl.getAllOrders();
	assert(orders.size() == orderList.size());
	
}
private List<Order> createOrdersDtoMockData(){
	List<Order> orders = new ArrayList<>();
	List<Product> product= new ArrayList<>();
	 Product obj=new Product();
	 obj.setPrice(11);
	 obj.setProductName("santooer");
	 obj.setQuantity(500);
	 product.add(obj);
	Order order = new Order();
	order.setStatus("order");
	order.setProduct(product);
	Customer obj1=new Customer();
//    order.setCustomer(obj1);
	order.setDate(new Date(2022,12, 1));
	orders.add(order);
	return orders;
}
@Test
void saveOrderTest() {

	OrderDto order1 = createOrderDtoMockData();	
	Order order=createOrderMockData();

	when(repo.save(order)).thenReturn(order);
	
    iOrderServiceImpl.saveOrder(order1);
	
	assert(order.getOrderId()==order1.getOrderId());
	
}
private OrderDto createOrderDtoMockData()
{
	long id=1;
	OrderDto odto=new OrderDto();
	odto.setOrderId(id);
	odto.setStatus("order");
	odto.setDate(new Date(2022, 10, 10));
//	Customer cus=new Customer();
//	cus.setCustomerId(id);
//	cus.setCustomerName("kiran");
//	cus.setEmail("abc.@abc.com");
//	cus.setPhoneNumber("999-123-1234");
	//odto.setCustomer(cus);
	List<ProductDto> product= new ArrayList<>();
	 ProductDto obj=new ProductDto();
	 obj.setPrice(11);
	 obj.setProductName("santooer");
	 obj.setQuantity(500);
	 product.add(obj);
	 odto.setProduct(product);
	return odto;
	
}
private Order createOrderMockData() 
{
	long id=1;
	Order odto=new Order();
	odto.setOrderId(id);
	odto.setStatus("order");
	odto.setDate(new Date(2022, 10, 10));
//	Customer cus=new Customer();
//	cus.setCustomerId(id);
//	cus.setCustomerName("kiran");
//	cus.setEmail("abc.@abc.com");
//	cus.setPhoneNumber("999-123-1234");
//	odto.setCustomer(cus);
	List<Product> product= new ArrayList<>();
	 Product obj=new Product();
	 obj.setPrice(11);
	 obj.setProductName("santooer");
	 obj.setQuantity(500);
	 product.add(obj);
	 odto.setProduct(product);
	return odto;
	 
}
@Test
void findbyIdTest() {
	OrderDto odto=createOrderDtoMockData();
	Optional<Order> order= Optional.of(createOrderMockData());
	long orderId=11;
	when(repo.findById(orderId)).thenReturn(order);
	OrderDto dto =iOrderServiceImpl.getOrder(orderId);
	assert(order.get().getOrderId()==dto.getOrderId());
	
}
@Test
void deleteByIdTest() {
	long id=1;
	
	 doNothing().when(repo).deleteById(id);
	 iOrderServiceImpl.deleteOrder(id);
     verify(repo, times(1)).deleteById(id);
}



}
