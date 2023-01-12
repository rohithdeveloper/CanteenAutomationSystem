package com.cg.service;

import java.util.List;


import com.cg.dto.CustomerDto;
import com.cg.entity.Customer;



public interface ICustomerService {
	List<CustomerDto> getAllCustomers();
	CustomerDto getCustomer(Long customerId);
	CustomerDto saveCustomer(CustomerDto customer);
	CustomerDto updateCustomer(Long customerId,CustomerDto customer);
	void deleteCustomer(Long customerId);
	public CustomerDto signIn(Long customerId,CustomerDto customer);

}
