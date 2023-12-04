package com.kh.springdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.kh.springdb.service.CustomerService;
import com.kh.springdb.vo.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public String getAllCustomers(Model model, @RequestParam(required=false) String customerId) {
		List<Customer> customers;
		customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "main";
	}
	
	
	//회원가입
	@GetMapping("/new")
	public String showCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerForm";
	}
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/ customers";
	}
	//탈퇴하기
	@GetMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteCustomerById(customerId);
		return "redirect:/customers";
	}
	//상세보기
	@GetMapping("details/{customerId}")
	public String getCustomerDetails(@PathVariable Long customerId, Model model) {
		Optional<Customer> customer = customerService.getCustomerById(customerId);
		customer.ifPresent(value -> model.addAttribute("customer", value));
		return "customerDetail";
	}
	
}
