package com.cg.controller;



import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.PaymentDto;
import com.cg.exception.PaymentNotFoundException;
import com.cg.service.IPaymentServices;


@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {

	Logger log=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	public IPaymentServices paymentService;
	
	@Validated
	@PostMapping("/addpayments")
	public PaymentDto addPayments (@RequestBody PaymentDto payments){
		PaymentDto products1= paymentService.addPayments(payments);
		log.info("payment Added successfully");
		return products1;
	}
	
	@GetMapping("/getPaymentsById/{paymentId}")
	public PaymentDto viewPayments(@PathVariable("paymentId") Long paymentId)throws PaymentNotFoundException
	{

		PaymentDto products = paymentService.viewPayments(paymentId);
		log.info("view Payment by Id");
		return products;
	
	}
	
	

	
	
}
