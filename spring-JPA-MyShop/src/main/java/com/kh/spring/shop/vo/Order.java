package com.kh.spring.shop.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="orders")
public class Order {
	//데이터베이스에 주문 정보를 저장하기 위한 클래스
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="orderId_seq")
	@SequenceGenerator(name="orderId_seq", sequenceName="orderId_seq", allocationSize = 1)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name="productId") 
	private Product product;
	private int quantity;
	
}
/*
 	@JoinColumn(name = "조인하고자하는 컬럼명") 외래키(Foreign Key)
 	데이터베이스의 테이블로 존재하는 객체를 생성 
 	private int quantity = 해당 제품의 수량을 표현 
 	
 	@ManyToOne
 	다대일(N : 1) 관계를 설정하는 어노테이션 
 	주문이 하나의 제품에 속하는 경우 product_id 값이 중복으로 들어갈 수 있음을 나타내기 위해 N:1
 	
 	
 */