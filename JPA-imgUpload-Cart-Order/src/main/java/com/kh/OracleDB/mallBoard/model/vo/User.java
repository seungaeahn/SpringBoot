package com.kh.OracleDB.mallBoard.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
//모든 필드값을 파라미터로 받을 수 있는 생성자 만들어줌
@AllArgsConstructor //Admin ad = new Admin(Admin 클래스 안에 있는 필드 모두 생성);
//파라미터가 없는 기본 생성자
@NoArgsConstructor //Admin ad = new Admin();
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
	private int id;
	
	@Column(unique = true) //닉네임 중복되지 않도록 설정
	private String userName;
	
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String role; //관리자인지 확인하기 위한 권한 설정 
	
	private int pay; //구매자: 충전한 금액 //판매자 : 판매한 금액 
	
	/*** 구매자용 필드 ***/
	//구매자용 장바구니
	private Cart cart;
	
	//구매자가 주문한 리스트
	@OneToMany(mappedBy="user")
	private List<Order> order = new ArrayList<>();
	
	//구매자가 주문한 상품리스트
	@OneToMany(mappedBy="user")
	private List<OrderItem> UserOrderItem = new ArrayList<>();
	
	
	/*** 판매자용 필드 ***/
	//판매자 상품리스트
	@OneToMany(mappedBy="seller")
	private List<SaleItem> SaleItem = new ArrayList<>();
	
	//판매 리스트
	@OneToMany(mappedBy="seller")
	private List<Sale> Sale = new ArrayList<>();
	
	//주문날짜와 판매날짜
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate;
	
	
	/*** 구매자와 판매자를 위한 필드 ***/
	//DB에 판매자나 구매자가 구매한 기록보다 먼저 날짜가 들어가면 안되기 때문에 미리 DB에 넣어줄 날짜 값을 미리 생성
	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
}










