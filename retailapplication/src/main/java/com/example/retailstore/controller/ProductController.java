package com.example.retailstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.retailstore.service.ProductsService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductsService productService;
	
	@GetMapping("/productindex")
	public String getProduct(ModelMap modelMap) {
		
		modelMap.addAttribute("products", productService.retrieveAllProducts());
		
		return "product/productindex";
	}

	@GetMapping("/productinsert")
	public String getProductInsert(Model model) {
		return "product/productinsert";
	}

	@PostMapping("/productinsert")
	public String postProductInsertSubmit() {
		
		return "result";
	}

	@GetMapping("/productdelete")
	public String getProductDelete() {
		return "product/productdelete";
	}

	@GetMapping("/productupdate")
	public String getProductUpdate() {
		return "product/productupdate";
	}

	@GetMapping("/productshow")
	public String getProductShow() {
		return "product/productshow";
	}

}
