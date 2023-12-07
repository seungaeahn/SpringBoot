package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//장바구니 목록 보여주기  위한 GetMapping 
	@GetMapping("/list")
	public String viewCart(Model model) {
		Cart cart = cartService.getCartById(1L);
		model.addAttribute("cart", cart);
		return "cartView";
	}
	
	//주소를 접속하기 위해서 GetMapping 
	@GetMapping("/add/{itemid}")
	public String addToCart(@PathVariable int itemId, Model model){
		//장바구니에 상품추가
		Item newItem = itemService.getItemById(itemId);
		//@PathVariable Long itemId 
		//만약에 파라미터 값이 Long일 경우에는 longValue() 작성을 해주고
		// .intValue() Integer 쓴 객체를 int로 변환하는 메서드
		//Item newItem = itemService.getItemById(itemId.intValue());
		//Integer와 int의 차이
		//Integer - Wrapper 클래스 객체로 감싸져 있기 때문에 null 값을 가질 수 있음
		//    int - java에서 기본 데이터 타입 정수를 나타내는값임 null값을 가질 수 없음
		
		//cartService.addCart
		//(장바구니이기때문에 누가 장바구니를 소유하고 있는지에 대한 값을 지정, 
													//newItem, 1);
		//임의의 값을 지정해줄 때 1L이라는 표현을 쓰기도 함
		// Long a = 3L;
		cartService.addCart(1L, newItem, 1);
		return "redirect:/";
		
	}
	@PostMapping("/add")
	public String addToCartItem(@RequestParam("itemId")Long itemId,Model model) {
		Item newItem = itemService.getItemById(itemId.intValue());
					// 1L 유저 아이값을나타낸 것 새로운 아이템 추가 1=카트에 추가할 아이템 수량
		cartService.addCart(1L, newItem, 1);
		
		return "redirect:/cart/list";
		
	}
	//결제 완료 후 장바구니 삭제하기 위한 메서드 추가
	@PostMapping("/checkout")
	public String checkout(RedirectAttributes redirectAttribute) {
		Long cartId = 1L;
		try {
		cartService.checkout(cartId);
		redirectAttribute.addFlashAttribute("checkoutStatus", "success");
		} catch (Exception e) {
		redirectAttribute.addFlashAttribute("checkoutStatus", "empty");	
		}
		return "redirect:/cart";
	}
	
	//RedirectAttributes : 리다이렉트할 때 속성을 전달하는데 사용
	//addFlashAttribute : 데이터를 추가할 때 리다이렉트 후 한번만 사용 가능, 사용 후에는 속성이 자동으로 삭제됨 
//							리다이랙트해서 돌아가고자하는 페이지로 이동할 때 속성이 존재하고, 돌아간 페이지에서 속성을 사용할 수 있음 
}





