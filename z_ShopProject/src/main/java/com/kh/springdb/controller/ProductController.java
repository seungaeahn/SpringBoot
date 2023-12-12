package com.kh.springdb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Product;
import com.kh.springdb.service.CommentService;
import com.kh.springdb.service.ProductService;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private final ProductService productService;
	
	@GetMapping("/")
	public String mainPageView(Model model) {
		return "index";
	}
	
	//페이지네이션 체크를 하기 위한 GetMapping 추가
		@GetMapping("/list")
		public String pageList(Model model,
				@RequestParam(value="page",defaultValue="0" ) int page) {
		// @RequestParam(value="page",defaultValue="0" )
			// 어떤 값을 가지고 요청을 할지 지정하기 위해 @RequestParam 이용했음
			// value="page" 값으로 page 이름을 받기로 지정
			//만약에 초반이나 후반에 어떤 값이 page 안에 없다면 page가 null값이라면
			//기본 값으로 0으로 설정해서 초기값을 null이 아닌 0으로 처리하겠다
			//페이지는 배열값으로 0이지만 변수에는 추후 1이 할당될 예정
			//페이지에는 1로 표기가 되지만 코드안에서는 0부터 시작하는 것으로 표기를 해줘야함
			Page<Product> paging = productService.getList(page);
			model.addAttribute("paging", paging);
			return "productList";
		}
	
	
	
	
	//상품 전체 목록 페이지로 이동하기 위한 @GetMapping
	@GetMapping("/product/list")
	public String getAllProducts(Model model) {
		model.addAttribute("products",productService.allProductView());
		//아이템을 추가한 서비스를 불러와서 모델에 넣어주기
		List<Product> products = productService.allProductView();
		model.addAttribute("products", products);
		return "productList";
	}
	
	//상품 등록 페이지 - 조회
	@GetMapping("/product/new")
	public String productSaveForm(Model model) {
		model.addAttribute("product", new Product());
		return "addProductForm";
	}
	
	//등록된 상품 업로드 페이지
	@PostMapping("/product/new")
	public String productSave(Product product, MultipartFile imgFile) throws IllegalStateException, IOException {
		productService.saveProduct(product, imgFile);
		return "redirect:/"; //상품 리스트 페이지로 변경해서 상품 등록 후 이동하는 경로를 바꿔줄 수 있음 
		
	}
	
	//상품 클릭했을때 상세보기 메서드
	@GetMapping("/detail/{id}")
	public String productDetail(@PathVariable("id") int id, Model model) {
		//상세보기 검색할 조건
		Product product = productService.getProductById(id);
		//하나의 아이디값을 가지고 와서 지정된 제품을 모든 내용을 보여줄 수 있도록 함 
		//"product" templates 밑에서 thymeleaf로 불러올 변수명을 product로 지정
		//Product product 만들어준 필드명을 가지고와서 service로 불러온 내용을 "product"안에 저장해준다는 의미
		model.addAttribute("product", product);
		return "product_detail";
	}
	
	private CommentService commentService;
	
	//댓글 작성하기 위한 PostMapping
	@PostMapping("/addComment")
	public String addComment(@RequestParam int productId, @RequestParam String commentContent) {
		commentService.addComment(productId, commentContent);
		return "redirect:/detail" + productId;
	}
	
	
}

































