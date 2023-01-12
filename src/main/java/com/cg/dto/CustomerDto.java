package com.cg.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.cg.entity.Customer;
import com.cg.entity.Order;
import com.cg.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	private Long customerId;
   //@NotBlank(message = "name must not be null or empty")
	private String customerName;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
	private String phoneNumber;
	@Email(message = "email must be in web-format abc@xyz.com")
	private String email;
	private String password;
	private List<Order> order;
}
