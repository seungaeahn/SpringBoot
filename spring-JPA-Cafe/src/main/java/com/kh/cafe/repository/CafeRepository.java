package com.kh.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kh.cafe.vo.Cafe;

import jakarta.persistence.Column;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long>{
	
//	//카페가 존재하는지 존재여부
//	boolean existByName(String name);
//	
	
	
	// count를 이용해서 지역의 갯수가 몇 개인지 찾아보는 메서드
	Long countByLocation(String location);
	
	
//	특정 문자열을 포함항 엔티티를 검색하는데 사용하는 메서드
	//@Query("SELECT c FROM Cafe WHERE c.name LIKE %:keyword%")
	List<Cafe> findByNameContaining(String keyword);
//	@Query("SELECT c FROM Cafe WHERE c.name LIKE %:keyword%")
//	//1. 만약에 보여줄 것이 많다. => List로 담아서 한 번에 보여주자!
//	List<Cafe> findCafe(@Param("keyword") String keyword);
//	//2. 보여줄 것이 하나 => Cafe 객체 하나만 호출할 것
/*	
	Query Creation : Spring Data JAP에서 제공하는 기능
					 메서드에 규칙이 존재하고 규칙에 따라서 메서드를 생성해주는 기능
					 메서드 이름으로 데이터베이스 쿼리를 생성
					 
					 findBy+내가찾고싶은변수명
					 예를 들어 Cafe라는 Class에 작성해놓은 
					 private String name;
					 private String location;
					 private String opening_hours;
	
					 지역을 검색하고 싶다면 
					 findByLocation(String location)
					  => SELECT * FROM Cafe WHERE location = ?
					 
					 findByNameContaining9String keyword);
					 Containing => 해당하는 변수명이 특정 변수에 대한 검색을 Like로 진행할 수 있게 도와줌 
					  
					 운영시간을 검색하고 싶다면
					 findByOpening_hours(String opening_hours)
					 => SELECT * FROM Cafe WHERE opening_hours = ?
					 총 갯수를 계산해주는 메서드를 만들고 싶다면 
					 countBy+클래스에적어준변수명
					 countByLocation(String location)
					 => SELECT COUNT(*) FROM Cafe WHERE location = ?
					 
					 존재여부를 확인해주는 메서드를 만들고 싶다면 
					 existBy+클래스에적어준변수명
					 existByLocation(String location)
					 => SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false
					  END FROM Cafe WHERE location = ?
					만약에 삭제하고 싶다면  
					deleteBy+클래스에적어준변수명
					deleteByLocation(String location)
					=> DELETE FROM Cafe WHERE location = ?
					
					
	Query -> AND OR IS Equals Between After Like OrderBy In False True IgnoreCase
		   
		   1. JPA에서 SQL AND 구문을 써야할 때
		   		findBy변수명AND다른변수명
		   2. JPA에서 SQL OR 구문을 써야할 때
		   		findBy변수명OR다른변수명
		   3. JPA에서 SQL IS 또는 Equals 구문을 써야할 때
		   		findBy변수명IS
		   		findBy변수명Equlas
		   4. JPA에서 SQL Between After Like 구문을 써야할 때		
		   		findBy변수명Between
		   		findBy변수명After
		   		findBy변수명Like
		   5. JPA에서 SQL OrderBy 구문을 써야할 때	
		   		findBy변수명OrderBy정렬하고자하는기준변수명Desc
		   		(* Desc : 내림차순)
		   		findBy변수명OrderBy정렬하고자하는기준변수명Asc
		   		(* Asc : 오름차순)
		   6. JPA에서 SQL In 구문을 써야할 때	
		   		findBy변수명In(List<예약어> 변수명)
		   7. JPA에서 SQL True False 구문을 써야할 때	
		   		findBy변수명True()
		   		findBy변수명False()
		   			SQL : WHERE 테이블명의 단축어.변수명(SQL테이블명) = true
		   			SQL : WHERE 테이블명의 단축어.변수명(SQL테이블명) = False
		   8. JPA에서 SQL IgnoreCase 구문을 써야할 때	
		   		findBy변수명IgnoreCase
		   			
		   		
*/	
}

















