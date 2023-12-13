package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Entity
@Getter @Setter
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize = 1)
	private Long id;
	
	//isRole 가입할 때마다 이 사람이 판매자인지 소비자인지 체크해서 가입하기
	@Enumerated(EnumType.STRING)
	private UserRole isRole;
	
	@Column(unique=true)
	private String username;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	
	
	//추천인을 넣고 싶다면 추천자를 생성해서 넣어도 됨 
	
	
}
