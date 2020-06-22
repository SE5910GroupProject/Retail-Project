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
import com.example.retailstore.form.customer.CreateCustomerForm;
import com.example.retailstore.form.customer.DeleteCustomerForm;
import com.example.retailstore.form.customer.ShowCustomerForm;
import com.example.retailstore.form.customer.UpdateCustomerForm;
import com.example.retailstore.model.Customer;
import com.example.retailstore.service.CustomersService;

@Controller
@RequestMapping("/customer")
public class CustomersController {

	@Autowired
	CustomersService customerService;
	
	@GetMapping("/customerindex")
	public String getCustomer() {
		return "/customer/customerindex";
	}

	@GetMapping("/customerinsert")
	public String getCustomerInsert(CreateCustomerForm createCustomerForm) {
		
		return "/customer/customerinsert";
	}
	
	@PostMapping("/customerinsert")
	public String postCustomerInsert(@Valid CreateCustomerForm createCustomerForm, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/customer/customerinsert";
		}
		else {
			customerService.insertCustomer(convertCreateToBO(createCustomerForm));
			model.addAttribute("successMSG", "Customer has been inserted successfully!");
			model.addAttribute("createCustomerForm", new CreateCustomerForm());
			
			return "/customer/customerinsert";
		}
	}
	
	@GetMapping("/customerupdate")
	public String getCustomerUpdate(UpdateCustomerForm updateCustomerForm) {
		
		return "/customer/customerupdate";
	}
	
	@PostMapping("/customerupdate")
	public String postCustomerUpdate(@Valid UpdateCustomerForm updateCustomerForm, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			return "/customer/customerupdate";
		}
		else {
			customerService.updateCustomer(convertUpdateToBO(updateCustomerForm));
			model.addAttribute("successMSG", "Customer has been updated successfully!");
			model.addAttribute("updateCustomerForm", new UpdateCustomerForm());
			
			return "/customer/customerupdate";
		}
	}

	@GetMapping("/customerdelete")
	public String getCustomerDelete(DeleteCustomerForm deleteCustomerForm) {
		return "/customer/customerdelete";
	}
	
	@PostMapping("/customerdelete")
	public String postCustomerDelete(@Valid DeleteCustomerForm deleteCustomerForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/customer/customerdelete";
		}
		else {
			customerService.deleteCustomer(deleteCustomerForm.getCustomerID());
			model.addAttribute("successMSG", "Customer has been deleted successfully!");
			model.addAttribute("deleteCustomerForm", new DeleteCustomerForm());
			
			return "/customer/customerdelete";
		}
	}
	
	@GetMapping("/customershow")
	public String getCustomerShow(ShowCustomerForm showCustomerForm) {
		return "/customer/customershow";
	}
	
	@PostMapping("/customershow")
	public String postCustomerShow(@Valid ShowCustomerForm showCustomerForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/customer/customershow";
		}
		else {
			List<Customer> customers = customerService.retrieveCustomersBetweenIdRange(showCustomerForm.getFrom(), showCustomerForm.getTo());
			model.addAttribute("customers", customers);
			model.addAttribute("showCustomerForm", new ShowCustomerForm());
			
			return "/customer/customershow";
		}
	}
	
	private Customer convertCreateToBO(CreateCustomerForm form) {
		Customer customer = new Customer();
		customer.setFirstName(form.getFirstName());
		customer.setLastName(form.getLastName());
		customer.setAddress(form.getAddress());
		customer.setCity(form.getCity());
		customer.setZipCode(form.getZipCode());
		customer.setCountry(form.getCountry());
		customer.setPhoneNumber(form.getPhoneNumber());
		customer.setBirthDate(form.getBirthDate());
		return customer;
	}
	
	private Customer convertUpdateToBO(UpdateCustomerForm form) {
		Customer customer = new Customer();
		customer.setCustomerID(form.getCustomerID());
		customer.setFirstName(form.getFirstName());
		customer.setLastName(form.getLastName());
		customer.setAddress(form.getAddress());
		customer.setCity(form.getCity());
		customer.setZipCode(form.getZipCode());
		customer.setCountry(form.getCountry());
		customer.setPhoneNumber(form.getPhoneNumber());
		customer.setBirthDate(form.getBirthDate());
		return customer;
	}

}
