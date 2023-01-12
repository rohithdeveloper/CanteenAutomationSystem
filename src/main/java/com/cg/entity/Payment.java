package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="paymentId")
	private Long paymentId;
	@Column(name="cardName")
	private String cardName;
	@Column(name="cardType")
	private String cardType;
	@Column(name="toatlCost")
	private Long toatlCost;
	@Column(name="bankName")
	private String bankName;



}
