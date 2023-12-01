package com.kh.board.vo;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name = "Board")
public class Board {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,
					generator="board_id_sequence")
	
	@SequenceGenerator(name="board_id_sequence",  sequenceName="board_id_sequence",
					allocationSize=1)
	
	@Column(name = "board_id")
	private Long boardId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "author")
	private String author;

}
/*
	@Lob : Blob, Clob 파일을 매핑
	@CreationTimestamp: insert 시 자동으로 저장
	@UpdateTimestamp : update 시 시간을 자동으로 지정
	@Temporal : 날짜 타입 매핑 
	@CreateDate : 엔티티가 생성되어 저잘될 때 시간을 저장 
	
	@Column : 테이블 안에 컬럼을 생성하거나 존재하는 테이블에 컬럼값을 찾아 매핑하는 역할을 함
			  option
			  	name : 데이터베이스에서 존재하는 컬럼이름과 자바 클래스에서 존재하는 field 이름이 일치하지 않을 경우
			  		   자바와 데이터베이스의 값이 일치할 수 있도록 매핑해주는 역할
			  	unique :유니크 제약 조건 생성 
			  	insertable : insert 가능 여부
			  	updatable : update 가능 여부
			  	length : String 타입의 문자 길이 제약조건 설정
			  	columnDefination : 데이터베이스 컬럼 정보를 직접 기술
			  	 				   @Column(columnDefination = "vachar(10) not null")
			  	precision : 큰 값에서 사용할 수 있음 / 소수점을 포함한 전체 자리수 
			  	scale(DDL) : 소수점 자리수 Double과 float 타입에는 적용되지 않음
	@GeneratedValue(strategy = GenerateType.)
			  	GenereationType.AUTO(default) : JPA 자동으로 알아서 생성 전략 결정 
			  	GenerationType.SEQUENCE : 데이터베이스 시퀀스를 이용해서 기본키를 생성
			  							  간혹 @SequenceGenerator를 사용해서 시퀀스를 등록할 필요가 없음 
			  	GenerationType.TABLE : 키 생성용 테이블 사용
			  						   @TableGenerator 필요
			  	GenerationType.IDENTITY : 기본키 생성을 데이터베이스에 넘겨줌
			  							  ex) mySQL 데이터베이스의 경우 AUTO_INCREMENT 사용해서 기본키를 생성
			  	
*/










































