package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springdb.service.AdminService;
import com.kh.springdb.vo.Customer;

@Controller
@RequestMapping("/admins")
public class AdminController {
	private final AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
//	@GetMapping("/search")
//	public String searchCustomers(@RequestParam String keyword, Model model) {
//		List<Customer> customers = adminService.findCustomer(keyword);
//		model.addAttribute("customers", customers);
//		return "searchResult";
//	}
//	
}
