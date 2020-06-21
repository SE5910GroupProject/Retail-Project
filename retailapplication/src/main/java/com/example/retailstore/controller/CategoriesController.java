package com.example.retailstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.retailstore.form.category.CreateCategoryForm;
import com.example.retailstore.form.category.DeleteCategoryForm;
import com.example.retailstore.form.category.ShowCategoryForm;
import com.example.retailstore.form.category.UpdateCategoryForm;
import com.example.retailstore.model.Category;
import com.example.retailstore.service.CategoriesService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	CategoriesService categoriesService;
	
	
	@GetMapping("/categoryinsert")
	public String getCategoryInsert(CreateCategoryForm createCategoryForm) {
		return "/categories/categoryinsert";
		
	}
	
	@PostMapping("/categoryinsert")
	public String postCategoryInsert(@Valid CreateCategoryForm createCategoryForm, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/categories/categoryinsert";
		}
		else {
			categoriesService.insertCategory(convertCreateToBO(createCategoryForm));
			model.addAttribute("successMSG", "Category has been inserted successfully!");
			model.addAttribute("createCategoryForm", new CreateCategoryForm());
			
			return "/categories/categoryinsert";
		}
	}
	
	
	@GetMapping("/categoryshow")
	public String getCategoryShow(ShowCategoryForm showCategoryForm) {
		return "/categories/categoryshow";
		
	}
	
	@PostMapping("/categoryshow")
	public String postCategoryShow(@Valid ShowCategoryForm showCategoryForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/category/categorydelete";
		}
		else {
			List<Category> categories = categoriesService.retrieveAllCategories();
			model.addAttribute("successMSG", "Category has been deleted successfully!");
			model.addAttribute("showCategoryForm", new ShowCategoryForm());
			
			return "category/categorydelete";
		}
	}
	
	@GetMapping("/categoryupdate")
	public String getCategoryUpdate(UpdateCategoryForm updateCategoryForm) {
		return "/categories/categoryupdate";
	}
	
	@PostMapping("/categoryupdate")
	public String postCategoryUpdate(@Valid UpdateCategoryForm updateCategoryForm, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			return "/categories/categoryupdate";
		}
		else {
			categoriesService.updateCategory(convertUpdateToBO(updateCategoryForm));
			model.addAttribute("successMSG", "Category has been updated successfully!");
			model.addAttribute("updateCategoryForm", new UpdateCategoryForm());
			
			return "/categories/categoryupdate";
		}
	}
	
	
	@GetMapping("/categorydelete")
	public String getCategoryDelete(DeleteCategoryForm deleteCategoryForm) {
		return "/categories/categorydelete";
		
	}
	
	@PostMapping("/categorydelete")
	public String postCategoryDelete(@Valid DeleteCategoryForm deleteCategoryForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/categories/categorydelete";
		}
		else {
			categoriesService.deleteCategory(deleteCategoryForm.getCategoryID());
			model.addAttribute("successMSG", "Category has been deleted successfully!");
			model.addAttribute("deleteCategoryForm", new DeleteCategoryForm());
			
			return "/categories/categorydelete";
		}
	}
	
	private Category convertCreateToBO(CreateCategoryForm form) {
		Category category = new Category();
		category.setCategoryName(form.getCategoryName());
		category.setDescription(form.getDescription());
		return category;
	}
	
	private Category convertUpdateToBO(UpdateCategoryForm form) {
		Category category = new Category();
		category.setCategoryID(form.getCategoryID());
		category.setCategoryName(form.getCategoryName());
		category.setDescription(form.getDescription());
		return category;
	}

}
