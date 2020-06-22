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
import com.example.retailstore.form.order.CreateOrderForm;
import com.example.retailstore.form.order.DeleteOrderForm;
import com.example.retailstore.form.order.ShowOrderForm;
import com.example.retailstore.form.order.UpdateOrderForm;
import com.example.retailstore.model.Order;
import com.example.retailstore.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	OrdersService orderService;
	
	@GetMapping("/orderindex")
	public String getOrder() {
		return "/orders/orderindex";
	}

	@GetMapping("/orderinsert")
	public String getOrderInsert(CreateOrderForm createOrderForm) {
		
		return "/orders/orderinsert";
	}
	
	@PostMapping("/orderinsert")
	public String postOrderInsert(@Valid CreateOrderForm createOrderForm, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/orders/orderinsert";
		}
		else {
			orderService.insertOrder(convertCreateToBO(createOrderForm));
			model.addAttribute("successMSG", "Order has been inserted successfully!");
			model.addAttribute("createOrderForm", new CreateOrderForm());
			
			return "/orders/orderinsert";
		}
	}
	
	@GetMapping("/orderupdate")
	public String getOrderUpdate(UpdateOrderForm updateOrderForm) {
		
		return "/orders/orderupdate";
	}
	
	@PostMapping("/orderupdate")
	public String postOrderUpdate(@Valid UpdateOrderForm updateOrderForm, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			return "/orders/orderupdate";
		}
		else {
			orderService.updateOrder(convertUpdateToBO(updateOrderForm));
			model.addAttribute("successMSG", "Order has been updated successfully!");
			model.addAttribute("updateOrderForm", new UpdateOrderForm());
			
			return "/orders/orderupdate";
		}
	}

	@GetMapping("/orderdelete")
	public String getOrderDelete(DeleteOrderForm deleteOrderForm) {
		return "/orders/orderdelete";
	}
	
	@PostMapping("/orderdelete")
	public String postOrderDelete(@Valid DeleteOrderForm deleteOrderForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/orders/orderdelete";
		}
		else {
			orderService.deleteOrder(deleteOrderForm.getOrderID());
			model.addAttribute("successMSG", "Order has been deleted successfully!");
			model.addAttribute("deleteOrderForm", new DeleteOrderForm());
			
			return "/orders/orderdelete";
		}
	}
	
	@GetMapping("/ordershow")
	public String getOrderShow(ShowOrderForm showOrderForm) {
		return "/orders/ordershow";
	}
	
	@PostMapping("/ordershow")
	public String postOrderShow(@Valid DeleteOrderForm showOrderForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/orders/orderdelete";
		}
		else {
			List<Order> orders = orderService.retrieveAllOrders();
			model.addAttribute("successMSG", "Order has been deleted successfully!");
			model.addAttribute("showOrderForm", new ShowOrderForm());
			
			return "/orders/orderdelete";
		}
	}
	
	private Order convertCreateToBO(CreateOrderForm form) {
		Order order = new Order();
		order.setCustomerID(form.getCustomerID());
		order.setUserID(form.getUserID());
		order.setPurchaseDate(form.getPurchaseDate());
		return order;
	}
	
	private Order convertUpdateToBO(UpdateOrderForm form) {
		Order order = new Order();
		order.setOrderID(form.getOrderID());
		order.setCustomerID(form.getCustomerID());
		order.setUserID(form.getUserID());
		order.setPurchaseDate(form.getPurchaseDate());
		return order;
	}

}
