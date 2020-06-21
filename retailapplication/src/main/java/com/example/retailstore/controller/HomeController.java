package com.example.retailstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	/*@GetMapping("/home/home")
	public ModelAndView getHome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		return model;
		
	}
	
	@GetMapping("/product/productindex")
	public ModelAndView getProduct() {
		ModelAndView model = new ModelAndView();
		model.setViewName("product/productindex");
		return model;
		
	}*/
	
	@GetMapping("/home/home")
	public String getHome() {
		return "home/home";
		
	}

}
