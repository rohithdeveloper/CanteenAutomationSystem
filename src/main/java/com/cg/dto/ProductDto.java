package com.cg.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	@NotBlank(message = "enter the product name")
	private String productName;
	private Long productId;
	@Min(1)
	private int quantity;
	@Min(50)
	private int price;

}
