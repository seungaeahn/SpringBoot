package com.kh.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.spring.shop.vo.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	//1. 회원가입 findAll 
	//2.로그인 findById
	//3. 마이페이지 getMemberDetails
	
	//4. 아이디 찾기 (이메일을 이용해서 아이디를 찾기!)
	Member findByEmail(String email);
}
