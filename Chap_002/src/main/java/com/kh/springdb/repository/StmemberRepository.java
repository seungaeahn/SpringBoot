package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.springdb.vo.STMEMBER;


@Repository
public interface StmemberRepository extends JpaRepository<STMEMBER, Long>{
	
}
