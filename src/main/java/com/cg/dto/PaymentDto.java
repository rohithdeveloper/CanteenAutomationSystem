package com.cg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDto {
	
	 
	private static final Long serialVersionUID = -7261195224819561477L;
	private Long paymentId;
	
	private String cardName;
	
	private String cardType;

	private Long toatlCost;
	
	private String bankName;

}
