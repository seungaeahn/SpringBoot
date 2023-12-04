package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.AdminRepository;
import com.kh.springdb.vo.Customer;

@Service
public class AdminService {
	private AdminRepository adminRepository;
	
	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
//	//유저 검색하기
//	public List<Customer> findCustomer(String keyword) {
//		return adminRepository.findByAdminIdContaining(keyword);
//	}
}
