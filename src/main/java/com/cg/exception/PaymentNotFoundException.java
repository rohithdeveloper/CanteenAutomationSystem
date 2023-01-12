package com.cg.exception;

import lombok.AllArgsConstructor;




import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class PaymentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final Long serialVersionUID = 1L;
	private String message;

}
