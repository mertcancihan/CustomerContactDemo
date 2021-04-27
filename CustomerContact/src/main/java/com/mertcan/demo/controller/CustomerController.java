package com.mertcan.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mertcan.demo.dto.CustomersDTO;
import com.mertcan.demo.entity.Customer;
import com.mertcan.demo.manager.CustomerManager;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {
	
	private CustomerManager customerManager;

	public CustomerController(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	@RequestMapping("/customer")
	public String homePage(Model model) {
		List<CustomersDTO> listCustomer = customerManager.getAll();
		model.addAttribute("customer", listCustomer);
		return "list-customer";
	}

	@RequestMapping("/new-customer")
	public String showNewCustomerPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new-customer";
	}
	
	@RequestMapping(value="/save-customer", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerManager.save(customer);
		return "redirect:/customer";
	}
	
	@RequestMapping("/edit-customer/{id}")
	public ModelAndView showEditContactForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit-customer");
		CustomersDTO customerDTO = customerManager.getById(id);
		mav.addObject("customer", customerDTO);
		return mav;
	}
}
