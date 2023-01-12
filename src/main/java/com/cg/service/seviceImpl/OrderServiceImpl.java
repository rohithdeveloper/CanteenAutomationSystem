package com.cg.service.seviceImpl;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CustomerDto;
import com.cg.dto.OrderDto;
import com.cg.dto.ProductDto;
import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.exception.OrderNotFoundException;
import com.cg.repository.OrderRepository;
//import com.cg.repository.ProductJPARepository;
import com.cg.repository.ProductRepository;
//import com.cg.repository.ProductRepository;
import com.cg.service.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService {
	Log LOGGER = LogFactory.getFactory().getLog(IOrderService.class);
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository repo;

	@Override
	public List<OrderDto> getAllOrders() {
		LOGGER.info("IOrderServiceImpl::getAllOrders::Entered");

		List<OrderDto> orders = new ArrayList<>();
		
		List<Order> ordersList = orderRepository.findAll();
		
		ordersList.stream().forEach(order -> {
	
			OrderDto orderDto = new OrderDto();
			orderDto.setOrderId(order.getOrderId());
			orderDto.setStatus(order.getStatus());
			orderDto.setDate(order.getDate());
			//orderDto.setCustomer(order.getCustomer());
            CustomerDto customerdto=new CustomerDto();
            
			List<ProductDto> productList = new ArrayList<>();
			order.getProduct().stream().forEach(product -> {
				ProductDto productDto = new ProductDto();
				 productDto.setProductName(product.getProductName());
				 productDto.setPrice(product.getPrice());
				 productDto.setProductId(product.getProductId());
				 productDto.setQuantity(product.getQuantity());
				 
				 productList.add(productDto);				
			});
			orderDto.setProduct(productList);
			orders.add(orderDto);
		});
		
		LOGGER.info("IOrderServiceImpl::getAllOrders::Exits");
		
		return orders;
	}
	@Override
	public OrderDto getOrder(long orderId) {
		LOGGER.info("IOrderServiceImpl::getOrder::Entered");
	  Optional<Order> orderOpt = orderRepository.findById(orderId);
			OrderDto orderDto = new OrderDto();
			if(orderOpt.isPresent()) {
				Order order= orderOpt.get();
			//	orderDto.setCustomer(order.getCustomer());
				orderDto.setDate(order.getDate());
				orderDto.setOrderId(order.getOrderId());
				orderDto.setStatus(order.getStatus());
				List<ProductDto> productList = new ArrayList<>();
				order.getProduct().stream().forEach(product -> {
					ProductDto productDto = new ProductDto();
					 productDto.setProductName(product.getProductName());
					 productDto.setPrice(product.getPrice());
					 productDto.setProductId(product.getProductId());
					 productDto.setQuantity(product.getQuantity());
					 productList.add(productDto);				
				});
				orderDto.setProduct(productList);
			}else {
			throw new OrderNotFoundException("no order with this ID:"+orderId+"");
		}
			LOGGER.info("IOrderServiceImpl::getOrder::Exits");
	return orderDto;
	}

	@Override
	public OrderDto saveOrder(OrderDto order) {
		LOGGER.info("IOrderServiceImpl::saveOrders::Entered");
			Order orderEntity = new Order();
			//orderEntity.setOrderId(order.getOrderId());
			orderEntity.setStatus(order.getStatus());
			orderEntity.setDate(order.getDate());
			//orderEntity.setCustomer(order.getCustomer());	
			List<Product> product = new ArrayList<>();
			
		    order.getProduct().stream().forEach(productDto -> {
				
				Product products = new Product();
				products.setPrice(productDto.getPrice());
				products.setProductName(productDto.getProductName());
				products.setQuantity(productDto.getQuantity());
				products.setProductId(productDto.getProductId());
				product.add(products);
				
			});
		  // repo.saveAll(product);
			orderEntity.setProduct(product);
			orderRepository.save(orderEntity);	
			repo.saveAll(product);		
			order.setOrderId(orderEntity.getOrderId());
			LOGGER.info("IOrderServiceImpl::saveOrder::Exit");
			return order;
		}

	@Override
	public OrderDto updateOrder(Long id,OrderDto order) {
		LOGGER.info("IOrderServiceImpl::updateOrders::Entered");
		Order obj=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("js"));
		//obj.setDate(order.getDate());
		obj.setStatus(order.getStatus());
		//obj.setCustomer(order.getCustomer());
		List<Product> product = new ArrayList<>();
		
	    order.getProduct().stream().forEach(productDto -> {
			
			Product products = new Product();
			products.setPrice(productDto.getPrice());
			products.setProductName(productDto.getProductName());
			products.setQuantity(productDto.getQuantity());
			products.setProductId(productDto.getProductId());
			product.add(products);
			
		});
	    obj.setProduct(product);
	    order.setOrderId(obj.getOrderId());
	    orderRepository.save(obj);
	    LOGGER.info("IOrderServiceImpl::updateOrders::exit");
		return order;
	}

	@Override
	public void deleteOrder(Long orderId) {
		LOGGER.info("IOrderServiceImpl::deleteOrder::Entered");
		Order obj=orderRepository.findById(orderId).orElseThrow(()->
		new OrderNotFoundException("no order with the id:"+orderId+" is found"));
	orderRepository.deleteById(orderId);
	LOGGER.info("IOrderServiceImpl::delete::Entered");
		
	}

}
