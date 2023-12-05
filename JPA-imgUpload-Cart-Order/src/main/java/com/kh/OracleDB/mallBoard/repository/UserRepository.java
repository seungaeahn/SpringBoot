package com.kh.OracleDB.mallBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.OracleDB.mallBoard.model.vo.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	//유저 조회
	User findByUsername(String username);
	//유저 아이디 찾기
	User findById(int id);
}
