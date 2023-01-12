package com.cg.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class OrderNotFoundException extends RuntimeException{
	private String message;

}
