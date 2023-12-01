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

import com.kh.springdb.service.ProductService;
import com.kh.springdb.vo.Product;

@Controller
//@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	 @GetMapping
	    public String getAllProducts(Model model) {
	        List<Product> products = productService.getAllProducts();
	        model.addAttribute("products", products);
	        return "product_list";
	    }

	    @GetMapping("/details/{id}")
	    public String getProductDetails(@PathVariable Long id, Model model) {
	        Optional<Product> product = productService.getProductById(id);
	        product.ifPresent(value -> model.addAttribute("product", value));
	        return "product_detail";
	    }
	    



	    @GetMapping("/new")
	    public String showProductForm(Model model) {
	        model.addAttribute("product", new Product());
	        return "product_form";
	    }

	    @PostMapping("/save")
	    public String saveProduct(@ModelAttribute Product product) {
	        productService.saveProduct(product);
	        return "redirect:/products";
	    }
	    @GetMapping("/update/{id}")
	    public String updateProduct(@PathVariable Long id, Model model) {
	    	Optional<Product> product = productService.getProductById(id);
	    	product.ifPresent(value -> model.addAttribute("product", value));
	    	return "product_form";
	    	
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable Long id) {
	        productService.deleteProductById(id);
	        return "redirect:/products";
	    }
	
	
	
/**
 
  	html -> 자바로 바로 통신할 수 있는게 없음
	jsp -> html과 java에서 가져온 내용을 연동하기 위해 사용하는 템플릿
			<% %>
	spring에서는 정말 완전하게 html은 html역할을 하고 자바는 자바역할을 했으면 좋겠다.
	
	thymeleaf : 역할 - spring에서 html과 java가 분리되게 thymeleaf를 xml에 포함시켜서 가져오는 일을 대신하게 함 

	자바에서 가져오는 내용을 html에 삽입해주기 위해 사용할 수 있는 xmls
	xml에서 사용하는 주소와 이름을 나타내는 공간
	xml : 데이터를 저장하고 전송하기 위해서 사용하는 언어
	
	
	th:text=DB에서 값을 가지고 옴
		th:text= "${product_id}" 		 ->getProductId
		th:text= "${product.product_id}" ->products 중에서 하나씩 가지고와서 넣어줄 때
	
		th:object="${product}" ->애초에 값을 하나만 가지고오겠다.
								1.새로운 값이 자동으로 들어가야할 수 있음	Insert
									
								2.기존에 있던 값이 또 한번 들어가야할 수 있음 Update
								
								->이럴바에는 html하나만 만들고 컨트롤러에서 메서드 하나만 추가해서
								메서드에서 기존에 id값이 있는지 없는지 존재 여부만 체크,
								만약 값이 있다면 수정으로 가고 값이 없다면 새로 만들기로 보내자
  	
  	
  	
  	
	Optional<Product> product = productService.getProductById(id);
	Optional 안에는 productService.getProductById(id);로 id값을 가져와서 id에 해당하는 제품을 가지고 옴 
	그런데 여기서 만약 id에 해당하는 제품이 존재하지 않는다면 Optional은 비어있게 됨 
	만약에 OPtional이 비어있게 된다면 에러가 발생할 수 있지만  (현재는)
	추후 비어있을 경우를 대비해서 예외값을 처리해주는 것이 좋음 
	예외값을 처리하는 방법 : orElse를 이용해서 대체값을 제공하거나 페이지 이동 처리를 할 수 있음 (ex. error.html) 
	이외에 orElseGet : 대체값을 생성하는 함수 제공
		 orElseThrow : 예외를 던짐 
	product.ifPresent(value -> model.addAttribute("product", value))
	ifPresent : Optional 객체 안에 값이 존재할 경우 람다식 표현을 실행하기 위한 메서드
		value값이 존재하면 모델에 product 변수명을 사용해서
		product 안에 value 값을 추가할 것 
		추가된 product는 html 템플릿 안에서 product를 thymeleaf를 통해 호출해서 value값을 사용할 수 있음 
		
		
	람다식 : 간결하게 함수를 표현하는 방법으로 간단하게 결과를 표현할 때 사용
		기본코드 : (변수값) -> 변수값이 존재하거나 어떤일을 발생할 경우의 결과를 작성 
		
		if(value != null) {
			
		}
		
 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
