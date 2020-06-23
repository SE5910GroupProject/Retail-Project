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
import com.example.retailstore.form.supplier.CreateSupplierForm;
import com.example.retailstore.form.supplier.DeleteSupplierForm;
import com.example.retailstore.form.supplier.ShowSupplierForm;
import com.example.retailstore.form.supplier.UpdateSupplierForm;
import com.example.retailstore.model.Supplier;
import com.example.retailstore.service.SuppliersService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

	@Autowired
	SuppliersService supplierService;
	
	@GetMapping("/supplierindex")
	public String getSupplier() {
		return "/suppliers/supplierindex";
	}

	@GetMapping("/supplierinsert")
	public String getSupplierInsert(CreateSupplierForm createSupplierForm) {
		
		return "/suppliers/supplierinsert";
	}
	
	@PostMapping("/supplierinsert")
	public String postSupplierInsert(@Valid CreateSupplierForm createSupplierForm, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/suppliers/supplierinsert";
		}
		else {
			supplierService.insertSupplier(convertCreateToBO(createSupplierForm));
			model.addAttribute("successMSG", "Supplier has been inserted successfully!");
			model.addAttribute("createSupplierForm", new CreateSupplierForm());
			
			return "/suppliers/supplierinsert";
		}
	}
	
	@GetMapping("/supplierupdate")
	public String getSupplierUpdate(UpdateSupplierForm updateSupplierForm) {
		
		return "/suppliers/supplierupdate";
	}
	
	@PostMapping("/supplierupdate")
	public String postSupplierUpdate(@Valid UpdateSupplierForm updateSupplierForm, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			return "/suppliers/supplierupdate";
		}
		else {
			supplierService.updateSupplier(convertUpdateToBO(updateSupplierForm));
			model.addAttribute("successMSG", "Supplier has been updated successfully!");
			model.addAttribute("updateSupplierForm", new UpdateSupplierForm());
			
			return "/suppliers/supplierupdate";
		}
	}

	@GetMapping("/supplierdelete")
	public String getSupplierDelete(DeleteSupplierForm deleteSupplierForm) {
		return "/suppliers/supplierdelete";
	}
	
	@PostMapping("/supplierdelete")
	public String postSupplierDelete(@Valid DeleteSupplierForm deleteSupplierForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/suppliers/supplierdelete";
		}
		else {
			supplierService.deleteSupplier(deleteSupplierForm.getSupplierID());
			model.addAttribute("successMSG", "Supplier has been deleted successfully!");
			model.addAttribute("deleteSupplierForm", new DeleteSupplierForm());
			
			return "/suppliers/supplierdelete";
		}
	}
	
	@GetMapping("/suppliershow")
	public String getSupplierShow(ShowSupplierForm showSupplierForm) {
		return "/suppliers/suppliershow";
	}
	
	@PostMapping("/suppliershow")
	public String postSupplierShow(@Valid ShowSupplierForm showSupplierForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/suppliers/suppliershow";
		}
		else {
			List<Supplier> suppliers = supplierService.retrieveSuppliersBetweenIdRange(showSupplierForm.getFrom(), showSupplierForm.getTo());
			model.addAttribute("suppliers", suppliers);
			model.addAttribute("showSupplierForm", new ShowSupplierForm());
			
			if(suppliers == null || suppliers.isEmpty()) {
				model.addAttribute("noRowsFound", "No Suppliers found between provided indexes.");
			}
			
			return "/suppliers/suppliershow";
		}
	}
	
	private Supplier convertCreateToBO(CreateSupplierForm form) {
		Supplier supplier = new Supplier();
		supplier.setCompanyName(form.getCompanyName());
		supplier.setContactName(form.getContactName());
		supplier.setContactDesignation(form.getContactDesignation());
		supplier.setPhoneNumber(form.getPhoneNumber());
		supplier.setAddress(form.getAddress());
		supplier.setCity(form.getCity());
		supplier.setZipCode(form.getZipCode());
		supplier.setCountry(form.getCountry());
		return supplier;
	}
	
	private Supplier convertUpdateToBO(UpdateSupplierForm form) {
		Supplier supplier = new Supplier();
		supplier.setSupplierID(form.getSupplierID());
		supplier.setCompanyName(form.getCompanyName());
		supplier.setContactName(form.getContactName());
		supplier.setContactDesignation(form.getContactDesignation());
		supplier.setPhoneNumber(form.getPhoneNumber());
		supplier.setAddress(form.getAddress());
		supplier.setCity(form.getCity());
		supplier.setZipCode(form.getZipCode());
		supplier.setCountry(form.getCountry());
		return supplier;
	}

}
