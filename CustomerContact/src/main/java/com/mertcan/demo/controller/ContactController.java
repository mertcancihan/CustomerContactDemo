package com.mertcan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mertcan.demo.dto.ContactDTO;
import com.mertcan.demo.entity.Contact;
import com.mertcan.demo.manager.ContactManager;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {
	
	@Autowired
	private ContactManager contactManager;

	public ContactController(ContactManager contactManager) {
		this.contactManager = contactManager;
	}

	@RequestMapping("/")
	public String homePage(Model model) {
		List<ContactDTO> listContact = contactManager.getAll();
		model.addAttribute("contact", listContact);
		return "index";
	}

	@RequestMapping("/new-contact")
	public String showNewContactPage(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "new-contact";
	}
	
	@RequestMapping(value="/save-contact", method=RequestMethod.POST)
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		contactManager.save(contact);
		System.out.print(contact.getStaff());
		return "redirect:/";
	}
	
	@RequestMapping("/edit-contact/{id}")
	public ModelAndView showEditContactForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit-contact");
		ContactDTO contactDTO = contactManager.getById(id);
		mav.addObject("contact", contactDTO);
		return mav;
	}
	
	@RequestMapping(value = "/delete-contact/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id){
        contactManager.delete(id);
        return "redirect:/";
    }
}
