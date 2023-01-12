package com.cg.service.seviceImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CustomerDto;
import com.cg.dto.ProductDto;
import com.cg.entity.Customer;
import com.cg.entity.Order;
import com.cg.entity.Product;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.PassWordWrongException;
import com.cg.exception.ProductNotFoundException;
import com.cg.repository.CustomerRepository;
import com.cg.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService  {

	@Autowired
	CustomerRepository repo;
	
	@Override
	public List<CustomerDto> getAllCustomers() {
    List<CustomerDto> customers = new ArrayList<>();
		
		List<Customer> customerList =repo.findAll();
		
		customerList .stream().forEach(customer -> {
			//LOGGER.debug("GroundServiceImpl::getAllGrounds::"+ground);
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerName(customer.getCustomerName());
			customerDto.setEmail(customer.getEmail());
			customerDto.setPhoneNumber(customer.getPhoneNumber());
			customerDto.setCustomerId(customer.getCustomerId());
		
			//customerDto.setOrder(customer.getOrder());
			customerDto.setPassword(customer.getPassword());
			//customerDto.setUserName(customer.getUserName());
			customers.add(customerDto);
			
	});
		return customers;
	}

	@Override
	public CustomerDto getCustomer(Long customerId) {
		Optional<Customer> customerOpt = repo.findById(customerId);
		CustomerDto  customerDto = new CustomerDto();
		if(customerOpt.isPresent()) {
			Customer customer = customerOpt.get();
			customerDto.setCustomerName(customer.getCustomerName());
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setPhoneNumber(customer.getPhoneNumber());
			customerDto.setEmail(customer.getEmail());
			customerDto.setOrder(customer.getOrder());
			customerDto.setPassword(customer.getPassword());
			//customerDto.setUserName(customer.getUserName());
			
			
		}else {
			throw new CustomerNotFoundException("Customer with id::"+customerId+" Not found");
	}
return customerDto;
	}
	

	@Override
	public CustomerDto saveCustomer(CustomerDto customer) {
		Customer customerEntity = new Customer();
		//	groundEntity.setGroundId(ground.getGroundId());
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setPhoneNumber(customer.getPhoneNumber());
		customerEntity.setOrder(customer.getOrder());
		customerEntity.setPassword(customer.getPassword());
		//customerEntity.setUserName(customer.getUserName());
			repo.save(customerEntity);
			customer.setCustomerId(customerEntity.getCustomerId());
			return customer;
	}

	@Override
	public CustomerDto updateCustomer(Long customerId, CustomerDto customer) {
		Customer customerEntity = repo.findById(customerId)
				 .orElseThrow(()->new CustomerNotFoundException("customer with id::"+customerId+" Not found") )	;
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setPhoneNumber(customer.getPhoneNumber());
		customerEntity.setOrder(customer.getOrder());
		customerEntity.setPassword(customer.getPassword());
		//customerEntity.setUserName(customer.getUserName());
		 repo.save(customerEntity);						
		return customer;
		}

	@Override
	public void deleteCustomer(Long customerId) {
		Customer customerEntity = repo.findById(customerId)
				.orElseThrow(()->new CustomerNotFoundException("customer with id::"+customerId+" Not found") )	;
		repo.deleteById(customerId);	
		
	}

	@Override
	public CustomerDto signIn(Long customerId,CustomerDto customer) throws PassWordWrongException {
		Customer user1=repo.findById(customerId).orElseThrow(()->new CustomerNotFoundException("customer with id::"+customerId+" Not found") )	;
		if(customer.getPassword().equals(user1.getPassword()))
		{
			return customer;
		}
		else
		{
			throw new PassWordWrongException ("Invaild login details");
		}
		
	}


}
