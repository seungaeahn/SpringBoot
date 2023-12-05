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

@Entity

@Getter @Setter
@Table(name="Product")
public class Product {
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="productId_Seq")
	@SequenceGenerator(name = "productId_Seq", sequenceName = "productId_Seq",allocationSize = 1)
	private Long id;
	private String product_name;
	private String category;
	private String price;
	private String stock_quantity;
	private String description;
	
}
/*
	@Table : 테이블 이름을 지정
	@Id : 해당 필드가 엔티티의 primarykey임을 나타냄
	@Column : 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있음
		nullable : 해당 컬럼이 null값을 허용하는지 여부를 나타냄
		
		
	Lombok
		@Builder :객체를 생성할 때 매개변수의 순서나 개수에 관계없이 보기 편할 수 있도록 객체를 생설할 수 있게 도와주는 메서드
		@All Args Constructor : 모든 필드에 생성자를 생성해줌
		객체를 생성할 때 모든 필드를 포함하는 생성자를 쉽게 만들 수 있음 
			예제코드 :
			@AllArgsConstructor
			public class Student {
				private String name; //new Student("학생명", 3);
				private int grade;
			}
		@No Args Constructor : 매개변수가 없는 기본 생성자를 생성 
			예제코드 : 
			@NoArgsConstructor
			public class School {
									//new School();
			}
			
	JPA 어노테이션
		@Prepersist :엔티티가 데이터베이스에 저장되기 전에 호출되는 메서드를 지정
			엔티티에 필요한 사전 처리 작업을 수행하는데 많이 사용
			
			예제코드 : 
			@Entity
			public class TestEntity {
				@Id
				private Long id;
				private String name;
				
				@DateTimeFormat(pattern = "yyyy-mm-dd")
				private Date createDate; //now라는 메서드를 활용해서 현재시간 기입 
				
				@Prepersist
				private void preWork() {
					//저장 전 수행할 작업을 작성
					//생성일자 작성, 특정 필드 초기화 
			    }
			    
			    @Prepersist
				private void createDate() {
					this.createDate = LocalDate.now();
			    }
		   }

*/


























