package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.springdb.vo.Admin;
import com.kh.springdb.vo.Customer;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
//	//고객 검색
//	List<Customer> findByAdminIdContaining(String keyword);
	
}
