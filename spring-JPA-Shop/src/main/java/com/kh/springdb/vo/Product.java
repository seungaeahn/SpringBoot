package com.kh.springdb.vo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Products")
public class Product {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")
//	@SequenceGenerator(name = "product_sequence", sequenceName="PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long product_id;
	@Column(nullable = false, length=50)
	private String product_name;
	@Column(nullable = false, length=50)
	private String category;
	@Column(name="price")
	private Double price;
	private Integer stock_quantity;
}
/**
 	@Table : 테이블 이름을 지정
 	@Id : 해당 필드가 엔티티의 primary key임을 나타냄 
 	@Column : 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있음 
 		nullable : 해당 컬럼이 null값을 허용하는지 여부를 나타냄
 		length : 문자열 컬럼의 최대 길이를 지정 
 		String으로 시작되는 필드 값의 경우 String으로 지정된 이름으로 명시되기 때문에 따로 이름을 지정해주지 않아도 되지만
 		String 이외의 값은 name을 설정해주어 Column 명을 지정해주는 것이 원칙 
 		
 		
 	@GeneratedValue JPA에서 엔티티의 기본키값을 자동으로 생성하는 방법을 지정하는데 사용하는 어노테이션 
 	//시퀀스를 사용해서 기본키 값을 생성할 수 있도록 지원
 	 * 시퀀스는 데이터베이스에서 중복되는 값이 아닌 각 레코드가 고유한 숫자번호를 가질 수 있도록 자동으로 값을 생성
 	 * @SequenceGenerator = GeneratedValue와 연결할 이름을 설정해주고 시퀀스의 이름과 크기를 지정할 수 있음 
 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName="PRODUCT_SEQ", allocationSize = 1)
	
	
	//데이터베이스 자체에서 값이 증가할 수 있도록 자동생성이 들어있는 경우 아래 어노테이션 방식을 사용
	 * 새로운 레코드가 삽일될 때마다 데이터베이스가 자동으로 기본키의 값을 증가시킴
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
 	MYBATIS
----------------------------------------	--------  ---------------
|	MODEL		mapper.xml		MAPPER	| |	SERVICE	| |	CONTROLLER 	|	VIEW
|										| |			| |				|
JPA										| |			| |  			|
|										| |			| |				|
|	MODEL		mapper.xml		MAPPER	| |	SERVICE	| |	CONTROLLER 	|	VIEW
-----------------------------------------  ----------  --------------

앞에서 진행했던 DB를 가져오는 구문을 처리하는 역할을 함
상호작용 (SELECT INSERT UPDATE DELETE)

HTML요청을 처리하고 사용자를 위한 데이터베이스를 서비스를 통해서 전달해줌
서비스에서 전달받은 결과를 VIEW에다가 전달해줌	
 */
