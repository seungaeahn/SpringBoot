package com.kh.spring.shop.vo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="paymentId_seq")
	@SequenceGenerator(name="paymentId_seq", sequenceName="paymentId_seq", allocationSize = 1)
	private Long paymentId;
	

	
	@ManyToOne
	@JoinColumn(name="paymentId") 
	private Order order;
	private int quantity;
	
}
