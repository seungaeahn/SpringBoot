package com.kh.OracleDB.mallBoard.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.OracleDB.mallBoard.model.vo.Item;
import com.kh.OracleDB.mallBoard.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //@NotNull로 표시된 필드를 사용해서 생성자를 생성 
public class ItemController {
	private final ItemService itemService;
	
	
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Item> items = itemService.allItemList();
		model.addAttribute("items", items);
		//view html과 연결하기 위해서 작성되는 페이지
		return "/index";
	}
	
	@GetMapping("")
	public String showItem(Model model) {
		model.addAttribute("", model);
		return "itemList";
	}
	
	@GetMapping("/item/list")
	public String itemList(Model model, @PageableDefault(size=12) Pageable pageable, @RequestParam(name="keyword", required = false) String keyword) {
		//페이지네이션 처리를 위한 서비스
		//검색을 하지 않고 페이지처리를 원함 
		//Page<Item> items = itemService.getItemByPage(pageable);
		
		
		return "itemList";
	}
	
	//@GetMapping 상품 등록 페이지 //admin만 등록할 수 있게 수정 
	@GetMapping("/new")
	public String addItemForm() {
		return "addItemForm.html";
	}
	
	//@PostMapping 상품 등록으로 입력된 값을 DB에 보내기
	@PostMapping("/save")
	public String saveItem(Item item, MultipartFile photoFile) throws IllegalStateException, IOException {
		// MultipartFile을 이용해서 상품을 등록할 때
		//이미지 파일도 같이 등록될 수 있도록 파라미터 생성 
		//itemService.addItem(item); //이미지없이 상품을 등록하고 싶다면 item만 작성해도 되지만 이미지 또한 포함해서 상품을 등록하고 싶다면 item, photoFile을 추가해서 작성 
		itemService.addItem(item, photoFile);
		return "redirect:/itemList";
	}
	
	//상품 상세
	@GetMapping("/view/{id}")
	public String viewItem(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("item", itemService.getItemById(id));
		return "viewItem";
	}
	
	//삭제
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
		itemService.itemDelete(id);
		return "itemList";
	}
	//수정
}
/*
	@RequiredArgsConstructor : 이 어노테이션이 적용된 클래스는 필수로 초기화해야하는 final 필드나 not null로 표시된 필드를 사용하는 생성자를 자동으로 생성해줌
	예제: 
		@RequiredArgsConstructor
		public class Student {
			private final String name;
			private final int grade;
			private String address;
		}
		name과 grade는 생성자에 포함되지만 address는 생성자에 포함되지 않음 
		나중에 Student 객체를 다른 데서 불러올 때
		Student st = new Student("이름", 5); //이름과 학년은 무조건 필수
		address는 넣어주지 않음 
*/