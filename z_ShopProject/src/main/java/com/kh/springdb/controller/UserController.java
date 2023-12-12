package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//	@Autowired
//	private UserService userService;
//	
//	//회원가입하고 회원가입 결과 @GetMapping @PostMapping
//	@GetMapping("/new")
//	public String joinMember(Model model) {
//		model.addAttribute("user", new User());
//		return "user/signup_form";
//	}
//	@PostMapping("/new")
//	public String addMember(@ModelAttribute User user) {
//		userService.saveMember(user);
//		return "redirect:/";
//	}
//	//로그인하고 로그인실패 @GetMapping @GetMapping
//	@GetMapping("/login")
//	public String loginMember() {
//		return "/user/login_form";
//	}
//	@GetMapping("/login/error")
//	public String loginError(Model model) {
//		model.addAttribute("loginErrorMsg", true);
//		//model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
//		return "/user/login_form";
//	}
//}