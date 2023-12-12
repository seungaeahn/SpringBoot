package com.kh.springdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name="user")
//@Getter @Setter
//public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
//	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize = 1)
//	private int id;
//	
//	private String name;
//	
//	private String email;
//	
//	private String password;
//	
//	private String address;
//}
