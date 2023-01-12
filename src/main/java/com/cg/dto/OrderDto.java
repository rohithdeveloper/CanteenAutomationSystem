package com.cg.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.cg.entity.Customer;
import com.cg.entity.Order;
import com.cg.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private Long orderId;
	private List<ProductDto> product;
	
	//@NotBlank(message = "name must not be null or empty")
	private String status;
	private Date date;
	

}
