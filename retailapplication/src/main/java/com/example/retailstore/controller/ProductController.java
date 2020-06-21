package com.example.retailstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.retailstore.form.CreateProductForm;
import com.example.retailstore.form.UpdateProductForm;
import com.example.retailstore.model.Product;
import com.example.retailstore.service.ProductsService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductsService productService;
	
	@GetMapping("/productindex")
	public String getProduct() {
		return "product/productindex";
	}

	@GetMapping("/productinsert")
	public String getProductInsert(CreateProductForm createProductForm) {
		
		return "/product/productinsert";
	}
	
	@PostMapping("/productinsert")
	public String postProductInsert(@Valid CreateProductForm createProductForm, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/product/productinsert";
		}
		else {
			productService.insertProduct(convertCreateToBO(createProductForm));
			model.addAttribute("successMSG", "Product has been inserted successfully!");
			model.addAttribute("createProductForm", new CreateProductForm());
			
			return "/product/productinsert";
		}
	}
	
	@GetMapping("/productdelete")
	public String getProductDelete() {
		return "product/productdelete";
	}

	
	@GetMapping("/productupdate")
	public String getProductUpdate(UpdateProductForm updateProductForm) {
		
		return "/product/productupdate";
	}
	
	@PostMapping("/productupdate")
	public String getProductUpdate(@Valid UpdateProductForm updateProductForm, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			return "/product/productupdate";
		}
		else {
			productService.updateProduct(convertUpdateToBO(updateProductForm));
			model.addAttribute("successMSG", "Product has been updated successfully!");
			model.addAttribute("updateProductForm", new CreateProductForm());
			
			return "product/productupdate";
		}
	}

	@GetMapping("/productshow")
	public String getProductShow() {
		return "product/productshow";
	}
	
	private Product convertCreateToBO(CreateProductForm form) {
		Product product = new Product();
		product.setSupplierID(form.getSupplierID());
		product.setCategoryID(form.getCategoryID());
		product.setProductName(form.getProductName());
		product.setUnitPrice(form.getUnitPrice());
		product.setQuantityPerUnit(form.getQuantityPerUnit());
		product.setUnitsInStock(form.getUnitsInStock());
		product.setDiscountPercent(form.getDiscountPercent());
		product.setProductStatus(form.getProductStatus());
		return product;
	}
	
	private Product convertUpdateToBO(UpdateProductForm form) {
		Product product = new Product();
		product.setID(form.getProductID());
		product.setSupplierID(form.getSupplierID());
		product.setCategoryID(form.getCategoryID());
		product.setProductName(form.getProductName());
		product.setUnitPrice(form.getUnitPrice());
		product.setQuantityPerUnit(form.getQuantityPerUnit());
		product.setUnitsInStock(form.getUnitsInStock());
		product.setDiscountPercent(form.getDiscountPercent());
		product.setProductStatus(form.getProductStatus());
		return product;
	}

}
