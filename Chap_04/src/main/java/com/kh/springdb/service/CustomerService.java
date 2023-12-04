package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.CustomerRepository;
import com.kh.springdb.vo.Customer;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	//전체 조회
		public List<Customer> getAllCustomers() {
			return customerRepository.findAll();
		}
	
	//가입하기
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//상세조회
	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findById(id);
	}
	
	//탈퇴하기
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}
}
