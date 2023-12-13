package com.kh.springdb.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="products")
@Getter @Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="products_seq")
	@SequenceGenerator(name="products_seq", sequenceName="products_seq", allocationSize = 1)
	private int id;
	
	private String name;
	
	private String text;
	
	private String price;
	
	private int count;
	
	private int stock;
	
	private int isSoldOut;
	
	//댓글작성을 위한 Comment
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<Comments> comments;
	
	private String imgName;
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate createDate;
	
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
	//제품에 대한 좋아요를 받고 싶다면 여기에 추천과 관련된 변수를 넣어줘도 됨
	//상품 좋아요 클릭해서 횟수 추가하기
	private int likes;
	//좋아요를 받는 방법은 여러 방법이 있음 
	//1. 사용자 관계없이 카운트만 올라가게 하기
	//2. ManytoOne이나 OneToMany 이용헤서 서로 카운트 주기
}
