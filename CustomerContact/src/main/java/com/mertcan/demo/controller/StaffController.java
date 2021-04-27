package com.mertcan.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mertcan.demo.dto.StaffDTO;
import com.mertcan.demo.entity.Staff;
import com.mertcan.demo.manager.StaffManager;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StaffController {

	private StaffManager staffManager;

	public StaffController(StaffManager staffManager) {
		this.staffManager = staffManager;
	}

	@RequestMapping("/staff")
	public String homePage(Model model) {
		List<StaffDTO> listStaff = staffManager.getAll();
		model.addAttribute("staff", listStaff);
		return "list-staff";
	}

	@RequestMapping("/new-staff")
	public String showNewStaffPage(Model model) {
		Staff staff = new Staff();
		model.addAttribute("staff", staff);
		return "new-staff";
	}
	
	@RequestMapping(value="/save-staff", method=RequestMethod.POST)
	public String saveStaff(@ModelAttribute("staff") Staff staff) {
		staffManager.save(staff);
		return "redirect:/staff";
	}
	
	@RequestMapping("/edit-staff/{id}")
	public ModelAndView showEditContactForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit-staff");
		StaffDTO staffDTO = staffManager.getById(id);
		mav.addObject("staff", staffDTO);
		return mav;
	}
}
