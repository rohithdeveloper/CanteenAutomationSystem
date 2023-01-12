package com.cg.service;

import com.cg.dto.PaymentDto;

public interface IPaymentServices {

	public PaymentDto addPayments(PaymentDto payments);
	

	public PaymentDto viewPayments(Long paymentId);

	
	
}
