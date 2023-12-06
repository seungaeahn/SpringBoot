package com.kh.springdb.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Item {
	//id name text price count stock isSoldout
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1)
	private int id;
	private String name;
	private String text;
	private String price;
	private int stock;
	private int isSoldout;
	
	//이미지 업로드를 위한 파일명, 이미지 경로, 상품 등록 날짜
	private String imgName;
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate createDate;
	
	//DB에 값을 넣을 때 자동으로 생성된 날짜가 들어감 
	@PrePersist
	public void createDate() {
		this.createDate = createDate;
	}
	
	//판매자가 누구인지, 장바구니에 어떤 아이템이 들어가져 있는지 x
	
	
}




















