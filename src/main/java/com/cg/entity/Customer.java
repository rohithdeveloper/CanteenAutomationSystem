package com.cg.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "customer_id")
	private Long customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Order> order;
	
	
	

}
