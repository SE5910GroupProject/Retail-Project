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
import com.example.retailstore.form.orderdetails.CreateOrderDetailsForm;
import com.example.retailstore.form.orderdetails.DeleteOrderDetailsForm;
import com.example.retailstore.form.orderdetails.ShowOrderDetailsForm;
import com.example.retailstore.form.orderdetails.UpdateOrderDetailsForm;
import com.example.retailstore.model.OrderDetails;
import com.example.retailstore.service.OrderDetailsService;

@Controller
@RequestMapping("/orderdetails")
public class OrderDetailsController {

	@Autowired
	OrderDetailsService orderDetailService;
	
	@GetMapping("/orderdetailindex")
	public String getOrderDetail() {
		return "/orderdetails/orderdetailindex";
	}

	@GetMapping("/orderdetailinsert")
	public String getOrderDetailInsert(CreateOrderDetailsForm createOrderDetailForm) {
		
		return "/orderdetails/orderdetailinsert";
	}
	
	@PostMapping("/orderdetailinsert")
	public String postOrderDetailInsert(@Valid CreateOrderDetailsForm createOrderDetailForm, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/orderdetails/orderdetailinsert";
		}
		else {
			orderDetailService.insertOrderDetails(convertCreateToBO(createOrderDetailForm));
			model.addAttribute("successMSG", "OrderDetail has been inserted successfully!");
			model.addAttribute("createOrderDetailForm", new CreateOrderDetailsForm());
			
			return "/orderdetails/orderdetailinsert";
		}
	}
	
	@GetMapping("/orderdetailupdate")
	public String getOrderDetailUpdate(UpdateOrderDetailsForm updateOrderDetailForm) {
		
		return "/orderdetails/orderdetailupdate";
	}
	
	@PostMapping("/orderdetailupdate")
	public String postOrderDetailUpdate(@Valid UpdateOrderDetailsForm updateOrderDetailForm, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			return "/orderdetails/orderdetailupdate";
		}
		else {
			orderDetailService.updateOrderDetails(convertUpdateToBO(updateOrderDetailForm));
			model.addAttribute("successMSG", "OrderDetail has been updated successfully!");
			model.addAttribute("updateOrderDetailForm", new UpdateOrderDetailsForm());
			
			return "/orderdetails/orderdetailupdate";
		}
	}

	@GetMapping("/orderdetaildelete")
	public String getOrderDetailDelete(DeleteOrderDetailsForm deleteOrderDetailForm) {
		return "/orderdetails/orderdetaildelete";
	}
	
	@PostMapping("/orderdetaildelete")
	public String postOrderDetailDelete(@Valid DeleteOrderDetailsForm deleteOrderDetailForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/orderdetails/orderdetaildelete";
		}
		else {
			orderDetailService.deleteOrderDetails(deleteOrderDetailForm.getOrderDetailsID());
			model.addAttribute("successMSG", "OrderDetail has been deleted successfully!");
			model.addAttribute("deleteOrderDetailForm", new DeleteOrderDetailsForm());
			
			return "/orderdetails/orderdetaildelete";
		}
	}
	
	@GetMapping("/orderdetailshow")
	public String getOrderDetailShow(ShowOrderDetailsForm showOrderDetailForm) {
		return "/orderdetails/orderdetailshow";
	}
	
	@PostMapping("/orderdetailshow")
	public String postOrderDetailShow(@Valid DeleteOrderDetailsForm showOrderDetailForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "/orderdetails/orderdetailshow";
		}
		else {
			List<OrderDetails> orderDetails = orderDetailService.retrieveAllOrderDetails();
			model.addAttribute("orderDetails", orderDetails);
			model.addAttribute("showOrderDetailsForm", new ShowOrderDetailsForm());
			
			return "/orderdetails/orderdetailshow";
		}
	}
	
	private OrderDetails convertCreateToBO(CreateOrderDetailsForm form) {
		OrderDetails orderDetail = new OrderDetails();
		orderDetail.setOrderID(form.getOrderID());
		orderDetail.setProductID(form.getProductID());
		orderDetail.setUnitPrice(form.getUnitPrice());
		orderDetail.setDiscount(form.getDiscount());
		return orderDetail;
	}
	
	private OrderDetails convertUpdateToBO(UpdateOrderDetailsForm form) {
		OrderDetails orderDetail = new OrderDetails();
		orderDetail.setOrderDetailsID(form.getOrderDetailsID());
		orderDetail.setOrderID(form.getOrderID());
		orderDetail.setProductID(form.getProductID());
		orderDetail.setUnitPrice(form.getUnitPrice());
		orderDetail.setDiscount(form.getDiscount());
		return orderDetail;
	}

}
