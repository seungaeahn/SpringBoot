package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.Item;
import com.kh.springdb.service.CartService;
import com.kh.springdb.service.ItemService;

@Controller
@RequestMapping("cart")
public class CartController {
	private final CartService cartService;
	private final ItemService itemService;
	
	
	public CartController(CartService cartService, ItemService itemService) {
		this.cartService = cartService;
		this.itemService = itemService;
	}
	
	//장바구니 목록 보여주기 위한 GetMapping
	public String viewCart(Model model) {
		Cart cart = cartService.getCartById(1L);
		model.addAttribute("cart", cart);
		return "cartView";
	}
	
	
	
	
	//주소를 접속하기 위해서 GetMapping
	@GetMapping("/add/{itemId}")
	public String addToCart(@PathVariable int itemId, Model model) {
		//장바구니에 상품 추가
		Item newItem = itemService.getItemById(itemId);
//		@PathVariable Long itemId 만약에 파라미터 값이 Long일 경우에는 longValue() 작성을 해주고
//		.intValue() Integer 쓴 객체를 int로 변환하는 메서드 
//		Item item = itemService.getItemById(itemId.intValue());
//		Integer와 int의 차이
//		Integer - Wrapper 클래스 객체로 감싸져 있기 때문에 null값을 가질 수 있음 
//			int - java에서 기본 데이터 타입 정수를 나타내는 값임 null값을 가질 수 없음 
		
		cartService.addCart(1L, newItem, 1);
		return "redirect:/cart";	
	}
	
	@PostMapping("/add")
	public String addToCartItem(@RequestParam("itemId") Long itemId) {
		Item newItem = itemService.getItemById(itemId.intValue());
		cartService.addCart(1L, newItem, 1);
		//1L 유저 아이디값을 나타낸 것 새로운 아이템 추가 1=카트에 추가할 아이템 수량 
		return "redirect:/cart";
	}
	
	
	
	
	
	
	
	
}
