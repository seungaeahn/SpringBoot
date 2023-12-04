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
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_id_seq")
	@SequenceGenerator(name="admin_id_seq", sequenceName="admin_id_seq", allocationSize=1)
	
	@Column(name="admin_id")
	private Long adminId;
	
	@Column(name="admin_pw")
	private String adminPw;
	
	
}



