package com.kh.spring.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.shop.service.ProductService;
import com.kh.spring.shop.vo.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//상품 전체보기
	@GetMapping
	public String getAllProducts(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		return "productList";
	}
	//상품 상세포기
	@GetMapping("details/{productId}")
	public String getProductDetails(@PathVariable Long productId, Model model) {
		Optional<Product> product = productService.getProductById(productId);
		return "productDetail";
	}
	//상품 추가하기
	@GetMapping("/new")
	public String displayProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	//상품 삭제하기
		@GetMapping("/delete/{productId}")
		public String deleteProduct(@PathVariable Long productId) {
			productService.deleteProductById(productId);
			return "redirect:/boards";
		}
	//상품 업데이트
		@GetMapping("/update/{productId}")
	    public String updateProduct(@PathVariable Long productId, Model model) {
	    	Optional<Product> product = productService.getProductById(productId);
	    	product.ifPresent(value -> model.addAttribute("product", value));
	    	return "productForm";
	    	
	    }
	
}
