package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.springdb.vo.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
