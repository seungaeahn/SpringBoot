package com.kh.springdb.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_id_seq")
	@SequenceGenerator(name="customer_id_seq", sequenceName="customer_id_seq", allocationSize=1)
	
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="customer_pw")
	private String customerPw;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	
}

