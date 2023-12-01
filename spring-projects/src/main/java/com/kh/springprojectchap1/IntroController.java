package com.kh.springprojectchap1;

import org.springframework.stereotype.Controller;

import com.kh.springPJ.GetMapping;
@Controller
public class IntroController {
	@GetMapping("/intro")
	public String getIntro() {
		return "intro";
	}
}
