package com.kh.cafe.controller;

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

import com.kh.cafe.service.CafeService;
import com.kh.cafe.vo.Cafe;

@Controller
@RequestMapping("/cafes")
public class CafeController {
	private final CafeService cafeService;
	
	@Autowired
	public CafeController(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	@GetMapping
	public String getAllCafes(Model model, @RequestParam(required=false) String name) {
		//@RequestParam(required=false) : 파라미터를 필수로 적어주지 않아도 됨을 나타냄 
		//@Requestparam http 요청으로 파라미터를 메서드의 매개변수로 전달할 때
		//클라이언트가 웹 애플리케이션에 보내는 요청의 파라미터 값을 받아서 처리하는데 사용 
		
		//@PathVariable과 @RequestParam의 차이
		//@PathVariable : url 경로에서 변수값을 추출 url /cafes/{id}
		//@Requestparam : 한 경로 안에서 클라이언트가 요청한 파라미터 값을 추출 url /cafes?name=사용자가 폼에 입력한 값 
		
		//카페리스트를 만들어준 후 만약에 리스트에서 카페가 존재한다면 그 카페 목록들만 보여주고
		//아니면 그냥 모든 카페 내용을 다 보여주겠다.
		List<Cafe> cafes;
		if(name != null && !name.isEmpty()) {
			cafes =cafeService.findCafe(name);
		}else {
			cafes = cafeService.getAllCafes();
		}
		model.addAttribute("cafes", cafes);
		return "cafeList";
	}
	//상세보기
	@GetMapping("/details/{cafeId}")
	public String getCafeDetails(@PathVariable Long cafeId, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(cafeId);
		cafe.ifPresent(value -> model.addAttribute("cafe", value));
		return "cafeDetail";
	}
	//추가하기
	@GetMapping("/new")
	public String displayCafeForm(Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafeForm";
	}
	@PostMapping("/save")
	public String saveCafe(@ModelAttribute Cafe cafe) {
		cafeService.saveCafe(cafe);
		return "redirect:/cafes";
	}
	//삭제하기
	@GetMapping("/delete/{cafeId}")
	public String deleteCafe(@PathVariable Long cafeId) {
		cafeService.deleteCafeById(cafeId);
		return "redirect:/cafes";
	}
	//모두 삭제
	@GetMapping("/delete/all")
	public String deleteAllCafes() {
		cafeService.deleteAllCafes();
		return "redirect:/cafes";
	}
	//검색하기
	@GetMapping("/search")
	public String searchCafes(@RequestParam String keyword, Model model) {
		//특정 키워드를 포함하는 카페를 검색
		List<Cafe> cafes = cafeService.findCafe(keyword);
		//모델에 검색결과 추가
		model.addAttribute("cafes", cafes);
		//검색 결과 보여줄 뷰 페이지 작성!
		return "searchResult";
	}
	
	//GetMapping을 활용해서 count해준 location을 가지고 오기
	@GetMapping("/count/{location}")
	public String countCafesByLocation(@PathVariable String location, Model model) {
		Long cafeCount = cafeService.countCafesByLocation(location);
		// 1. 지역값을 저장할 모델
		model.addAttribute("location", location);
		// 2. 지역 갯수를 저장해줄 모델
		model.addAttribute("cafeCount", cafeCount);
		return "cafeCount";
	}
	
//	//카페가 존재하는지 확인 여부
//	@GetMapping("/exists/{name}")
//	public String existsCafeByName(@PathVariable String name, Model model) {
//		boolean cafeExists = cafeService.existsCafeByName(name);
//		model.addAttribute("cafeExists", cafeExists);
//		return "cafeExists";
//	}
	
	
	
	
}
