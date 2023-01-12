package com.cg.advice;

import java.util.LinkedHashMap
;

import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.OrderNotFoundException;
import com.cg.exception.ProductNotFoundException;
import com.cg.exception.StaffNotFoundException;

@RestControllerAdvice
public class CanteenAutomationSystemExceptionHandler {
	
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String, String> handleBadRequest(MethodArgumentNotValidException ex){
			Map<String, String> erros = new LinkedHashMap<>();
			ex.getBindingResult().getFieldErrors().forEach(error -> {
				erros.put(error.getField(), error.getDefaultMessage());
			});
			
			return erros;		
		}
		
		
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(Exception.class)
		public String internalServerError(Exception ex){
			return ex.getMessage();
		}
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(StaffNotFoundException.class)
		public String notFoundHandlaer(StaffNotFoundException ex){
			return ex.getMessage();
		}
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(ProductNotFoundException.class)
		public String notFoundHandlaer(ProductNotFoundException ex){
			return ex.getMessage();
		}
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(CustomerNotFoundException.class)
		public String notFoundHandlaer(CustomerNotFoundException ex){
			return ex.getMessage();
		}
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(OrderNotFoundException.class)
		public String notFoundHandlaer(OrderNotFoundException ex){
			return ex.getMessage();
		}
		
		
		

	}


