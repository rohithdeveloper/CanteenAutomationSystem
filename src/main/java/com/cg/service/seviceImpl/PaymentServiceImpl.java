package com.cg.service.seviceImpl;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.dto.PaymentDto;
import com.cg.entity.Payment;
import com.cg.exception.PaymentNotFoundException;
import com.cg.repository.PaymentJPARepository;
import com.cg.service.IPaymentServices;


@Service
public class PaymentServiceImpl implements IPaymentServices {
	@Autowired
     PaymentJPARepository repository;

	@Override
	public PaymentDto addPayments(PaymentDto payments) {
		// TODO Auto-generated method stub
		Payment obj=new Payment();
		obj.setBankName(payments.getBankName());
		obj.setCardName(payments.getCardName());
		obj.setCardType(payments.getCardType());
		obj.setPaymentId(payments.getPaymentId());
		obj.setToatlCost(payments.getToatlCost());
		repository.save(obj);
		
		return payments;
	}

	@Override
	public PaymentDto viewPayments(Long paymentId) {
		// TODO Auto-generated method stub
		Payment p=repository.findById(paymentId).orElseThrow(()-> new PaymentNotFoundException("np product with"+paymentId));
		PaymentDto paymentdto=new PaymentDto();
		paymentdto.setBankName(p.getBankName());
		paymentdto.setCardName(p.getCardName());
		paymentdto.setCardType(p.getCardType());
		paymentdto.setPaymentId(p.getPaymentId());
		paymentdto.setToatlCost(p.getToatlCost());
		
		return paymentdto;
	}

	
}