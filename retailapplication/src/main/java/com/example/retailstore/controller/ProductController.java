package com.example.retailstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.retailstore.model.Product;
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
	public ModelAndView getProductInsert() {
		ModelAndView model = new ModelAndView();
		model.addObject("product", new Product());
		model.setViewName("product/productinsert");
		
		return model;
	}
	
	@PostMapping("/productinsert")
	public ModelAndView postProductInsert(@Valid Product product, BindingResult bindingResult) {
		
		ModelAndView model = new ModelAndView();
		
		productService.insertProduct(product);
		
		model.addObject("product", new Product());
		model.setViewName("product/productinsert");
		
		return model;
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
