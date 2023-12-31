package com.kh.spring.shop.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter @Setter
public class Product {
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="productId_seq")
	@SequenceGenerator(name="productId_seq", sequenceName="productId_seq", allocationSize = 1)
	private Long productId;
	
	private String product_name;
	
	private String category;
	
	private String price;
	
	private String stock_quantity;
	
	private String description;
}
