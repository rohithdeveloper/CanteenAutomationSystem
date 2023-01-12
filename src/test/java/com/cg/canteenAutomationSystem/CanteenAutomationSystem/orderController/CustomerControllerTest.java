package com.cg.canteenAutomationSystem.CanteenAutomationSystem.orderController;


import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.cg.controller.CustomerController;
import com.cg.dto.CustomerDto;
import com.cg.service.ICustomerService;


@ExtendWith(MockitoExtension.class)

public class CustomerControllerTest {

	@InjectMocks
	CustomerController customercontroller;
	@Mock
	ICustomerService customerservice;
	
	
	
	@Test
	void testCreateProduct() {    
		 
		CustomerDto customer = createCustomerDtoMockData();
		
	when(customerservice.saveCustomer(customer)).thenReturn(customer);
		
		CustomerDto CustomerDto =customercontroller.saveCustomer(customer);
		
		assert(customer.getCustomerId() == CustomerDto.getCustomerId());
		
	}

	@Test
	void testViewCustomer() {
		long id=1;
		CustomerDto customerId = createCustomerDtoMockData();
		when(customerservice.getCustomer(id)).thenReturn(customerId);
		CustomerDto customerdto = customercontroller.getCustomerById(id);
		assert(customerId.getCustomerId() == customerdto.getCustomerId());
	}
	
	@Test
	void ViewAllCustomers() {
		List<CustomerDto> customers = createAllCustomerDtoMockData();
		
		when(customerservice.getAllCustomers()).thenReturn(customers);
		List<CustomerDto> customerList = customercontroller.getCustomers();
		assert(customers.size() == customerList.size());
	}
	
	@Test
	void testUpdateCustomer() {
		long id=1;
		CustomerDto customerdto =createCustomerDtoMockData();
			when(customerservice.updateCustomer( id, customerdto)).thenReturn(customerdto);
			CustomerDto customer = customercontroller.updateCustomer(id, customerdto);
			assert(customerdto.getCustomerId()==  customer.getCustomerId() );
		}      
	          
	
	@Test
	void testDeleteCustomer() {
		long id=1;
		String msg="successfully deleted product";
		doNothing().when(customerservice).deleteCustomer(id);
		String message = customercontroller.deleteCustomer(id);
		assert(message.equals(message));
		
	}


	private List<CustomerDto> createAllCustomerDtoMockData() {
		// TODO Auto-generated method stub
		List<CustomerDto> customer =new ArrayList<>();
		CustomerDto customerdto =new CustomerDto();
		customerdto.setCustomerId((long) 1234);
		customerdto.setCustomerName("rahu");
		customerdto.setEmail("abc@gmail.com");
		customerdto.setPhoneNumber("7995311320");
		return customer;
		
	}

	private CustomerDto createCustomerDtoMockData() {
		// TODO Auto-generated method stub
		CustomerDto customerdto =new CustomerDto();
		customerdto.setCustomerId((long) 1234);
		customerdto.setCustomerName("rahu");
		customerdto.setEmail("abc@gmail.com");
		customerdto.setPhoneNumber("7995311320");
		return customerdto;
	}


	
}




	